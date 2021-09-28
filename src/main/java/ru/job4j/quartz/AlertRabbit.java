package ru.job4j.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class AlertRabbit {

    public static void main(String[] args) {
        try {
            List<Long> store = new ArrayList<>();
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDataMap data = new JobDataMap();
            try (Connection connection = getConnection()) {
                data.put("store", connection);
                JobDetail job = newJob(Rabbit.class)
                        .usingJobData(data)
                        .build();
                SimpleScheduleBuilder times = simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever();
                Trigger trigger = newTrigger()
                        .startNow()
                        .withSchedule(times)
                        .build();
                scheduler.scheduleJob(job, trigger);
                Thread.sleep(10000);
            }
            scheduler.shutdown();
        //    System.out.println(store);
        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
      try (InputStream in = AlertRabbit.class.getClassLoader().getResourceAsStream("rabbit.properties")) {
          Properties config = new Properties();
          config.load(in);
          Class.forName(config.getProperty("driver-class-name"));
          connection = DriverManager.getConnection(
                  config.getProperty("url"),
                  config.getProperty("username"),
                  config.getProperty("password")
          );

      } catch (Exception e) {
          throw new IllegalStateException(e);
      }
      return connection;
    }

    public static class Rabbit implements Job {

        public Rabbit() {
            System.out.println(hashCode());
        }

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("Rabbit runs here ...");
            Connection connection = (Connection) context.getJobDetail().getJobDataMap().get("store");
            try (PreparedStatement statement = connection.prepareStatement(
                    "insert into rabbit(created_date) values (?)")) {
                      statement.setLong(1, System.currentTimeMillis());
                System.out.println(System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
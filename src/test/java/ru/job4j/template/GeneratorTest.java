package ru.job4j.template;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;



import java.util.HashMap;
import java.util.Map;


public class GeneratorTest  {

    @Ignore
    @Test
    public void generatorWork() {
        GeneratorTemplate generatorTemplate = new GeneratorTemplate();
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("name", "Вася");
        stringMap.put("subject", "you");
        generatorTemplate.produce("I am a ${name}, Who are ${subject}? ", stringMap);
        assertThat(generatorTemplate, is(new GeneratorTemplate()));
    }
    @Ignore
    @Test(expected = Exception.class)
    public void thereAreNoSuchKeysInTheMap() {
        GeneratorTemplate generatorTemplate = new GeneratorTemplate();
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("name", "Вася");
        stringMap.put("subject", "you");
        generatorTemplate.produce("I am a ${name}, Who are ${subject}? My name is ${yourName} ", stringMap);
        assertThat(generatorTemplate, is(new GeneratorTemplate()));
    }
    @Ignore
    @Test(expected = Exception.class)
    public void thereAreNoSuchKeysInTheTemplate() {
        GeneratorTemplate generatorTemplate = new GeneratorTemplate();
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("name", "Вася");
        stringMap.put("subject", "you");
        stringMap.put("yourName", "Коля");
        generatorTemplate.produce("I am a ${name}, Who are ${subject}?", stringMap);
        assertThat(generatorTemplate, is(new GeneratorTemplate()));
    }
}
package processors;

interface Processor {
    String name();
    Object process(Object input);
}


package com.gik.testsProject.gik.lambda.collect.partitioningBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Partitioner {

    public static Map<Boolean, List<Application>> getPartition(List<Application> applications) {
        Map<Boolean, List<Application>> map = applications.stream()
                .collect(Collectors.partitioningBy(Application::isFree));
        return map;
    }
}

class Application {
    private final String name;
    private final boolean isFree;

    public Application(String name, boolean isFree) {
        this.name = name;
        this.isFree = isFree;
    }

    public String getName() {
        return name;
    }

    public boolean isFree() {
        return isFree;
    }
}

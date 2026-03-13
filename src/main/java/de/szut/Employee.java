package de.szut;

public record Employee (
        String name,
        int companyService,
        int performancePoints,
        int completedProjects,
        int absentDays,
        boolean teamLeader
){}

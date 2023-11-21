package com.test.concurrent;

import java.util.concurrent.Phaser;

public class PhaserTeamDevelopmentExample {
    public static void main(String[] args) {
        final int numberOfDevelopers = 3;
        Phaser sprintPhaser = new Phaser(1); // Initial party count is 1 (main thread)

        for (int i = 0; i < numberOfDevelopers; i++) {
            new Thread(new Developer(sprintPhaser, "Developer " + (i + 1))).start();
        }

        // Main thread (Scrum Master) starts the sprint
        System.out.println("Sprint started!");
        sprintPhaser.arriveAndDeregister(); // Allow developers to start working

        // Simulating work in phases (e.g., coding, testing, review)
        for (int phase = 1; phase <= 3; phase++) {
            System.out.println("Phase " + phase + " in progress...");
            sprintPhaser.arriveAndAwaitAdvance(); // Wait for all developers to finish the phase
        }

        System.out.println("Sprint completed!");
    }

    static class Developer implements Runnable {
        private final Phaser sprintPhaser;
        private final String developerName;

        Developer(Phaser sprintPhaser, String developerName) {
            this.sprintPhaser = sprintPhaser;
            this.developerName = developerName;
            sprintPhaser.register(); // Register each developer with the sprintPhaser
        }

        @Override
        public void run() {
            System.out.println(developerName + " started working.");

            for (int phase = 1; phase <= 3; phase++) {
                // Simulating work in each phase
                System.out.println(developerName + " working on Phase " + phase);
                sprintPhaser.arriveAndAwaitAdvance(); // Developer finished the phase
            }

            System.out.println(developerName + " completed all phases.");
            sprintPhaser.arriveAndDeregister(); // Unregister developer at the end
        }
    }
}

package Commands;

import Utilities.Invoker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

import static Utilities.Runner.scriptScanner;
public class ExecuteScript implements Command{



    @Override
    public void execute(String args) {


        try {
            scriptScanner = new Scanner(new File(args));
            Map<String, Command> commands = Invoker.getCommands();

            while (scriptScanner.hasNextLine()) {

                String[] input = scriptScanner.nextLine().split(" ");
                String userCommand = input[0];
                String userArgs = "";
                if (input.length == 2) userArgs = input[1];
                if (userCommand.equals("execute_script")) {
                    if (userArgs.equals(args)) {
                        System.out.println("Не возможно выполнить рекурсию");
                        return;
                    } else try {
                        scriptScanner = new Scanner(new File(userArgs));

                        while (scriptScanner.hasNextLine()) {

                            String[] input1 = scriptScanner.nextLine().split(" ");
                            String userCommand1 = input1[0];
                            String userArgs1 = "";
                            if (input1.length == 2) userArgs1 = input1[1];
                            if (userCommand1.equals("execute_script")) {
                                if (userArgs1.equals(args) || userArgs1.equals(userArgs)) {
                                    System.out.println("Не возможно выполнить рекурсию");
                                    return;
                                } else new ExecuteScript().execute(userArgs1);
                            }
                            if (commands.containsKey(userCommand1)) {
                                if (userCommand1.equals("add") || userCommand1.equals("add_if_min") || userCommand1.equals("update")) {
                                    commands.get(userCommand1).executeInScript(userArgs1);
                                } else commands.get(userCommand1).execute(userArgs1);
                            }
                        }

                    } catch (FileNotFoundException e) {
                        System.out.println("Файла с таким названием нет");
                    }
                }
                if (commands.containsKey(userCommand)) {
                    if (userCommand.equals("add") || userCommand.equals("add_if_min") || userCommand.equals("update")) {
                        commands.get(userCommand).executeInScript(userArgs);
                    } else commands.get(userCommand).execute(userArgs);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файла с таким названием нет");
        }

    }

    @Override
    public String getName() {
        return "execute_script";
    }
}

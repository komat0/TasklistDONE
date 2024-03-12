package tasklist

import kotlinx.datetime.LocalDate
import java.time.format.DateTimeParseException
import java.util.regex.Pattern


fun main() {
    val taskList = mutableListOf<List<String>>()

    while (true) {
        println("Input an action (add, print, edit, delete, end):")
        val userInput = readln().trim()

        when {
            userInput == "add" -> {
                FuncCompanion.add(taskList)
            }

            userInput == "delete" -> {
                FuncCompanion.print(taskList)
                FuncCompanion.delete(taskList)
            }

            userInput == "edit" -> {
                FuncCompanion.print(taskList)
                FuncCompanion.edit(taskList)
            }

            userInput == "print" -> {
                FuncCompanion.print(taskList)
            }

            userInput == "end" -> {
                println("Tasklist exiting!")
                break
            }

            else -> println("The input action is invalid")
        }
    }

    if (taskList.isEmpty()) println("No tasks have been input")
}

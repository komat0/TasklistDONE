package tasklist

import kotlinx.datetime.LocalDate
import java.time.format.DateTimeParseException
import java.util.regex.Pattern

fun dateAsker(): String {
    var taskPriority = ""
    var taskDate = ""
    var taskTime = ""

    while (true) {
        println("Input the task priority (C, H, N, L):")
        taskPriority = readLine()?.uppercase() ?: ""
        if (taskPriority in setOf("C", "H", "N", "L")) break
    }

    while (true) {
        println("Input the date (yyyy-mm-dd):")
        val inputDate = readLine()?.trim() ?: ""

        if (inputDate.length == 10) {
            try {
                val date = LocalDate.parse(inputDate)
                taskDate = date.toString()
                break
            } catch (e: DateTimeParseException) {
                println("The input date is invalid")
            } catch (e: IllegalArgumentException) {
                println("The input date is invalid")
            }
        } else if (inputDate.length < 10) {
            val parts = inputDate.split("-")
            try {
                val year = parts[0].toInt()
                val month = parts[1].toInt()
                val day = parts[2].toInt()
                val date = LocalDate(year, month, day)
                taskDate = date.toString()
                break
            } catch (e: DateTimeParseException) {
                println("The input date is invalid")
            } catch (e: IllegalArgumentException) {
                println("The input date is invalid")
            } catch (e: NumberFormatException) {
                println("The input date is invalid")
            }
        } else println("The input date is invalid")
    }

    while (true) {
        println("Input the time (hh:mm):")
        taskTime = readLine()?.trim() ?: ""

        val pattern = Pattern.compile("([01]?[0-9]|2[0-3]):([0-5]?[0-9])")
        val matcher = pattern.matcher(taskTime)

        if (matcher.matches()) {
            break
        } else {
            println("The input time is invalid")
        }
    }

    return "$taskDate $taskTime $taskPriority"
}

fun main() {
    val taskList = mutableListOf<List<String>>()

    while (true) {
        println("Input an action (add, print, end):")
        val userInput = readln().trim()

        when {
            userInput == "add" -> {
                val taskData = dateAsker()
                println("Input a new task (enter a blank line to end):")
                val taskListInner = mutableListOf<String>()
                taskListInner.add(taskData)
                while (true) {
                    val task = readLine()?.trim()
                    if (task.isNullOrEmpty()) {
                        if (taskListInner.size == 1) println("The task is blank")
                        break
                    }
                    taskListInner.add(task)
                }
                taskList.add(taskListInner)
            }

            userInput == "print" -> {
                var spaceFirstCounter = "  "
                var spaceSecondCounter = "  "
                if (taskList.isEmpty() ||
                    taskList.firstOrNull()?.firstOrNull().isNullOrEmpty()
                ) {
                    println("No tasks have been input")
                } else {
                    for ((index, taskListInner) in taskList.withIndex()) {
                        val indexNumber = index + 1
                        if (index > 8) spaceFirstCounter = " "
                        println("$indexNumber$spaceFirstCounter${taskListInner.first()}")
                        for (i in 1..taskListInner.lastIndex)
                            println("$spaceSecondCounter ${taskListInner[i]}")
                        println()
                    }
                }
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

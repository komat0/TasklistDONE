package tasklist

import kotlinx.datetime.*
import java.time.format.DateTimeParseException
import java.util.regex.Pattern

class FuncCompanion {
    companion object {

        fun print(taskList: MutableList<List<String>>) {
            var indexSpacer = "  "
            val stringWidth = 44
            val emptyLine = "|    |            |       |   |   "

            if (isListEmpty(taskList)) {
                println("No tasks have been input")
            } else {
                // Print header
                printSeparator()
                printHeader()
                printSeparator()
                // Print all lines from the taskListInner
                for ((index, taskListInner) in taskList.withIndex()) {
                    // Add +1 for printing 0 index like 1
                    val indexNumber = index + 1
                    // Change spaces depend on number size
                    if (index > 8) indexSpacer = " " else indexSpacer = "  "
                    // Print index Part
                    print("| $indexNumber$indexSpacer|")

                    // Parse and print first line from the taskListInner (Date information)
                    val parts = taskListInner.first().split(" ")
                    val taskDate = parts[0]
                    val taskTime = parts[1]
                    val taskPriority = colorCheck(parts[2])
                    val taskDue = colorCheck(parts[3])
                    // Print Data and priority bloc
                    print(" $taskDate | $taskTime | $taskPriority | $taskDue |")

                    for (j in 1 until taskListInner.size) {
                        val taskText = taskListInner[j].chunked(stringWidth)
                        if (j == 1) {
                            println("${taskText.first().padEnd(stringWidth, ' ')}|")
                            if (taskText.size > 1)
                                for (k in 1 until taskText.size)
                                    println("$emptyLine|${taskText[k].padEnd(stringWidth, ' ')}|")
                        } else {
                            for (k in 0 until taskText.size)
                                println("$emptyLine|${taskText[k].padEnd(stringWidth, ' ')}|")
                        }
                    }
                    printSeparator()
                }
            }
        }

        fun add(taskList: MutableList<List<String>>) {
            val taskDate = dateAndPriorityAsker()
            println("Input a new task (enter a blank line to end):")
            val taskListInner = mutableListOf<String>()
            taskListInner.add(taskDate)
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

        fun delete(taskList: MutableList<List<String>>) {

            while (true) {
                if (isListEmpty(taskList)) break

                println("Input the task number (1-${taskList.size}):")

                val delIndex = readln()

                try {
                    val index = delIndex.toInt()
                    if (index !in 1..taskList.size) {
                        println("Invalid task number")
                        continue
                    } else {
                        taskList.removeAt(index - 1)
                        println("The task is deleted")
                        break
                    }
                } catch (e: NumberFormatException) {
                    println("Invalid task number")
                }
            }
        }

        fun edit(taskList: MutableList<List<String>>) {

            outerEditCycle@ while (true) {

                if (isListEmpty(taskList)) break
                println("Input the task number (1-${taskList.size}):")

                try {
                    val editIndex = readln().toInt()
                    if (editIndex > taskList.size || editIndex <= 0) {
                        println("Invalid task number")
                        continue@outerEditCycle
                    } else {
                        innerEditCycle@ while (true) {
                            println("Input a field to edit (priority, date, time, task):")
                            val userEditChoose = readln()

                            when (userEditChoose) {
                                "priority" -> {
                                    println("Input the task priority (C, H, N, L):")
                                    val replacementPriority = readln()
                                    val taskForEdit = taskList[editIndex - 1].toMutableList()
                                    val modifiedTask = taskForEdit[0].replaceRange(17, 18, replacementPriority)
                                    taskForEdit[0] = modifiedTask
                                    taskList[editIndex - 1] = taskForEdit
                                    println("The task is changed")
                                    break@outerEditCycle
                                }

                                "date" -> {
                                    println("Input the date (yyyy-mm-dd):")
                                    val replacmentDate = readln()
                                    val dateFormat = dateCheck(replacmentDate)
                                    val taskForEdit = taskList[editIndex - 1].toMutableList()
                                    val modifiedTask = taskForEdit[0].replaceRange(0, 10, dateFormat)
                                    taskForEdit[0] = modifiedTask
                                    taskList[editIndex - 1] = taskForEdit
                                    println("The task is changed")
                                    break@outerEditCycle
                                }

                                "time" -> {
                                    println("Input the time (hh:mm):")
                                    val replacmentTime = readln()
                                    val timeFormat = timeCheck(replacmentTime)
                                    val taskForEdit = taskList[editIndex - 1].toMutableList()
                                    val modifiedTask = taskForEdit[0].replaceRange(11, 16, timeFormat)
                                    taskForEdit[0] = modifiedTask
                                    taskList[editIndex - 1] = taskForEdit
                                    println("The task is changed")
                                    break@outerEditCycle
                                }

                                "task" -> {
                                    println("Input a new task (enter a blank line to end):")
                                    val replacmentTask = readln()
                                    val taskForEdit = taskList[editIndex - 1].toMutableList()
                                    val modifiedTask =
                                        taskForEdit[1].replaceRange(0, taskForEdit[1].length, replacmentTask)
                                    taskForEdit[1] = modifiedTask
                                    taskList[editIndex - 1] = taskForEdit
                                    println("The task is changed")
                                    break@outerEditCycle
                                }

                                else -> {
                                    println("Invalid field")
                                    continue@innerEditCycle
                                }
                            }
                        }
                    }
                } catch (e: NumberFormatException) {
                    println("Invalid task number")
                }
            }
        }

        fun dateAndPriorityAsker(): String {
            var taskPriority: String
            var taskDate: String
            var taskTime: String

            while (true) {
                println("Input the task priority (C, H, N, L):")
                taskPriority = readLine()?.uppercase() ?: ""
                if (taskPriority in setOf("C", "H", "N", "L")) break
            }

            while (true) {
                println("Input the date (yyyy-mm-dd):")
                val inputDate = readLine()?.trim() ?: ""
                taskDate = dateCheck(inputDate)
                if (taskDate != "") break else continue
            }

            while (true) {
                println("Input the time (hh:mm):")
                val inputDate = readLine()?.trim() ?: ""
                taskTime = timeCheck(inputDate)
                if (taskTime != "") {
                    break
                } else {
                    println("The input time is invalid")
                }
            }

            return "$taskDate $taskTime $taskPriority ${daysUntil(taskDate)}"
        }

        fun daysUntil(input: String): Char {
            val taskDate = input.toLocalDate()
            val currentDate = Clock.System.now().toLocalDateTime(TimeZone.of("UTC+0")).date
            val numberOfDays = currentDate.daysUntil(taskDate)
            return if (numberOfDays == 0) {
                'T'
            } else if (numberOfDays > 0) {
                'I'
            } else {
                'O'
            }
        }

        fun isListEmpty(taskList: MutableList<List<String>>): Boolean {
            return taskList.isEmpty() ||
                    taskList.firstOrNull()?.firstOrNull()?.isEmpty() ?: true
        }

        fun dateCheck(inputDate: String): String {
            var taskDate = ""
            if (inputDate.length == 10) {
                try {
                    val date = LocalDate.parse(inputDate)
                    taskDate = date.toString()
                } catch (e: DateTimeParseException) {
                    println("The input date is invalid")
                } catch (e: IllegalArgumentException) {
                    println("The input date is invalid")
                }
            } else if (inputDate.length < 10) {
                val parts = inputDate.split("-")
                try {
                    val yearPart = parts[0].toInt()
                    var monthPart = parts[1].toInt()
                    val month = if (monthPart.toString().length == 1) "0$monthPart" else monthPart.toString()
                    var dayPart = parts[2].toInt()
                    val day = if (dayPart.toString().length == 1) "0$dayPart" else dayPart.toString()
                    val date = LocalDate(yearPart, month.toInt(), day.toInt())
                    taskDate = date.toString()
                } catch (e: DateTimeParseException) {
                    println("The input date is invalid")
                } catch (e: IllegalArgumentException) {
                    println("The input date is invalid")
                } catch (e: NumberFormatException) {
                    println("The input date is invalid")
                }
            } else {
                println("The input date is invalid")
            }
            return taskDate
        }

        fun timeCheck(inputTime: String): String {
            var taskTime = inputTime
            if (inputTime == "0:0") taskTime = "00:00"
            val pattern = Pattern.compile("(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]|\\d)")
            val matcher = pattern.matcher(taskTime)
            if (!matcher.matches()) {
                taskTime = ""
            }
            return taskTime
        }

        fun printHeader() {
            println("| N  |    Date    | Time  | P | D |                   Task                     |")
        }

        fun printSeparator() {
            println("+----+------------+-------+---+---+--------------------------------------------+")
        }

        fun colorCheck(c: String): String {
            return when (c) {
                "C", "O" -> "\u001B[101m \u001B[0m"
                "H", "T" -> "\u001B[103m \u001B[0m"
                "N", "I" -> "\u001B[102m \u001B[0m"
                else -> "\u001B[104m \u001B[0m"
            }
        }
    }
}
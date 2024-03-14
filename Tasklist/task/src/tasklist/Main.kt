package tasklist


fun main() {

    val taskList = mutableListOf<List<String>>()

//    taskList.add(mutableListOf("2024-03-13 12:00 H T", "Test Task First Line", "Test task Second Line", "Tretya stroka dlya testa budet dlinnoy chto by zaodno posmotret na perenosi stroki. I voobshe kaka rabotaet."))
//    taskList.add(mutableListOf("2024-03-13 12:00 H T", "\"Tretya stroka dlya testa budet dlinnoy chto by zaodno posmotret na perenosi stroki. I voobshe kaka rabotaet.\"", "Test task Second Line", "Tretya stroka"))
//    taskList.add(mutableListOf("2024-03-13 12:00 H T", "Test Task First Line", "Test task Second Line", "Tretya stroka dlya testa budet dlinnoy chto by zaodno posmotret na perenosi stroki. I voobshe kaka rabotaet."))
//    taskList.add(mutableListOf("2024-03-13 12:00 H T", "Test Task First Line", "\"Tretya stroka dlya testa budet dlinnoy chto by zaodno posmotret na perenosi stroki. I voobshe kaka rabotaet.\"", "Tretya stroka dlya"))
//    taskList.add(mutableListOf("2024-03-13 12:00 H T", "Test Task First Line", "Test task Second Line", "Tretya stroka dlya testa budet dlinnoy chto by zaodno posmotret na perenosi stroki. I voobshe kaka rabotaet."))
//    taskList.add(mutableListOf("2024-03-13 12:00 H T", "Test Task First Line", "Test task Second Line", "Tretya stroka dlya testa budet "))
//    taskList.add(mutableListOf("2024-03-13 12:00 H T", "Test Task First Line", "Test task Second Line", "Tretya stroka dlya testa budet dlinnoy chto by zaodno posmotret na perenosi stroki. I voobshe kaka rabotaet."))
//    taskList.add(mutableListOf("2024-03-13 12:00 H T", "Test Task First Line", "Test task Second Line", "Tretya stroka dlya testa budet dlinnoy chto by zaodno posmotret na perenosi stroki. I voobshe kaka rabotaet."))
//    taskList.add(mutableListOf("2024-03-13 12:00 H T", "Test Task First Line", "Test task Second Line", "Tretya stroka dlya testa budet dlinnoy chto by zaodno posmotret na perenosi stroki. I voobshe kaka rabotaet."))
//    taskList.add(mutableListOf("2024-03-13 12:00 H T", "Test Task First Line", "Test task Second Line", "Tretya stroka dlya testa budet dlinnoy chto by zaodno posmotret na perenosi stroki. I voobshe kaka rabotaet."))
//    taskList.add(mutableListOf("2024-03-13 12:00 H T", "Test Task First Line", "Test task Second Line", "Tretya stroka dlya testa budet dlinnoy chto by zaodno posmotret na perenosi stroki. I voobshe kaka rabotaet."))
//
//    FuncCompanion.print(taskList)

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

// Concept Note: https://docs.google.com/document/d/1beXGl4HIOR247oB3-ErK0KrTdtsVtqyyMpT_3PLzGec/edit?usp=sharing
//Group 12
//137326 - Tatiana Ziyane
//169470 - Safari Pascal Amindja
//148349 - Mwangi Lindsey Wanjiru
//191481 - Bwashi Champion David
//186909 - Elizabeth Waithera
//169099 - Asoh Great

fun main() {

    //Stores the name of the system
    val systemName = "RENT MANAGEMENT SYSTEM"

    //Creates a list to store tenant names
    val tenants = mutableListOf<String>()

    //Creates a list to store house numbers
    val houseNumbers = mutableListOf<String>()

    //Creates a list to store the monthly rent for each tenant
    val monthlyRents = mutableListOf<Double>()

    //Creates a list to store the amount of rent paid by each tenant
    val amountsPaid = mutableListOf<Double>()

    //Creates a list to store the outstanding balance for each tenant
    val balances = mutableListOf<Double>()


    println("========================================")
    println("       $systemName")
    println("========================================")
    println("Welcome to the Rent Management System!")
    println("========================================")


    //true means the program will continue running
    var continueProgram = true

    //Keeps displaying the main menu while continueProgram is true
    while (continueProgram) {

        println()
        println("----------------------------------------")
        println("MAIN MENU")
        println("----------------------------------------")
        println("1. Enter and Register the Details of the Tenant")
        println("2. View Stored Tenant Details")
        println("3. Exit")
        println("----------------------------------------")
        print("Please select an option: ")

        //toIntOrNull() converts the input into an integer
        //If the user enters something that is not a number, it returns null
        val choice = readLine()?.toIntOrNull()

        //Checks which option the user selected
        when (choice) {

            1 -> {
                println()
                println("========================================")
                println("       TENANT REGISTRATION")
                println("========================================")

                print("Please enter the tenant's name: ")
                val tenantName = readLine()?.trim()

                //Checks whether the tenant name was left empty
                if (tenantName.isNullOrEmpty()) {
                    println("Error: Tenant name cannot be empty.")
                } else {


                    print("Please enter the house number: ")
                    val houseNumber = readLine()?.trim()


                    //Checks whether the house number was left empty
                    if (houseNumber.isNullOrEmpty()) {
                        println("Error: House number cannot be empty.")
                    } else {

                        print("Please enter the monthly rent (KES): ")
                        val monthlyRent = readLine()?.toDoubleOrNull()


                        //It must be a number and greater than 0
                        if (monthlyRent == null || monthlyRent <= 0) {
                            println("Error: Please enter a valid monthly rent amount.")
                        } else {

                            print("Please enter the amount of rent paid (KES): ")
                            val amountPaid = readLine()?.toDoubleOrNull()



                            //Checks whether the payment amount is valid and the amount cannot be negative
                            if (amountPaid == null || amountPaid < 0) {
                                println("Error: Please enter a valid payment amount.")

                                //Checks if the tenant paid more than the monthly rent
                            } else if (amountPaid > monthlyRent) {
                                println("Error: Amount paid cannot be greater than the monthly rent.")
                            } else {

                                println()
                                println("Processing rent payment...")


                                //Calculates the amount of the rent that is still unpaid
                                //Balance = Monthly Rent - Amount Paid
                                val outstandingBalance = monthlyRent - amountPaid


                                //Stores the tenant's information in the lists
                                tenants.add(tenantName)
                                houseNumbers.add(houseNumber)
                                monthlyRents.add(monthlyRent)
                                amountsPaid.add(amountPaid)
                                balances.add(outstandingBalance)




                                //Displays a summary of the information
                                println("----------------------------------------")
                                println("RENT PAYMENT SUMMARY")
                                println("----------------------------------------")
                                println("Tenant: $tenantName")
                                println("House Number: $houseNumber")
                                println("Monthly Rent: KES ${"%,.0f".format(monthlyRent)}")
                                println("Amount Paid: KES ${"%,.0f".format(amountPaid)}")
                                println("Outstanding Balance: KES ${"%,.0f".format(outstandingBalance)}")
                                println("----------------------------------------")

                                println("Tenant record saved successfully.")
                            }
                        }
                    }
                }
            }

            2 -> {
                println()
                println("========================================")
                println("          TENANT RECORDS")
                println("========================================")

                if (tenants.isEmpty()) {
                    println("No tenant records have been registered yet.")
                    println("Please register a tenant first.")
                } else {

                    for (i in tenants.indices) {

                        val paymentStatus = when {
                            balances[i] == 0.0 -> "FULLY PAID"
                            amountsPaid[i] == 0.0 -> "NOT PAID"
                            else -> "PARTIALLY PAID"
                        }

                        println()
                        println("----------------------------------------")
                        println("Tenant ${i + 1}")
                        println("----------------------------------------")
                        println("Tenant Name: ${tenants[i]}")
                        println("House Number: ${houseNumbers[i]}")
                        println("Monthly Rent: KES ${"%,.0f".format(monthlyRents[i])}")
                        println("Amount Paid: KES ${"%,.0f".format(amountsPaid[i])}")
                        println("Outstanding Balance: KES ${"%,.0f".format(balances[i])}")
                        println("Payment Status: $paymentStatus")
                    }

                    println()
                    println("========================================")
                    println("Total Tenants Registered: ${tenants.size}")
                    println("========================================")
                }
            }

            3 -> {
                println()
                println("========================================")
                println("Thank you for using the Rent Management System.")
                println("========================================")

                continueProgram = false
            }

            else -> {
                println()
                println("Invalid option.")
                println("Please select 1, 2, or 3 from the menu.")
            }
        }
    }
}
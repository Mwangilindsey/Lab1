// ============================================================
// ===================== LAB 3 - TASK 2 ========================
// ============================================================

// Tenant class improved using a primary constructor
class Tenant(
    val name: String,
    val apartmentNumber: Int,
    val rentAmount: Double
) {
    // The payment status still starts as false
    var isPaid: Boolean = false

    // Method to pay rent
    fun payRent() {
        isPaid = true
    }
}

fun main() {

    println("\n---=== LAB 3: TASK 2 =====--")

    // The first tenant from Task 1 is now created
    // using the new primary constructor
    val tenant1 = Tenant("John", 101, 15000.0)

    // The second tenant from Task 1 is now created
    // using the new primary constructor
    val tenant2 = Tenant("Mary", 102, 18000.0)

    // Call payRent() for only the first tenant
    tenant1.payRent()

    // Display the payment status of both tenants
    println("${tenant1.name} rent paid: ${tenant1.isPaid}")
    println("${tenant2.name} rent paid: ${tenant2.isPaid}")

    // Think About It:
    // The advantage of passing information through a constructor
    // is that the important information is provided when the
    // object is created. This makes the code cleaner and easier
    // to understand.
}
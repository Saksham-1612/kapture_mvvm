package com.example.kapture.sample_data

import com.example.kapture.model.Ticket
import java.util.*
import kotlin.random.Random

object TicketSampleData {

    private val subjects = listOf(
        "Important Update", "Meeting Reminder", "Project Proposal", "Invoice Attached",
        "Feedback Request", "LinkedIn - New Connection", "Follow-Up Email", "Job Application",
        "Newsletter Subscription", "Weekly Report", "Client Feedback", "Server Downtime Notification",
        "New Assignment", "Holiday Plans", "Project Update", "Birthday Invitation",
        "Monthly Report", "Congratulations!", "Annual Meeting", "Job Offer"
    )

    private val emails = listOf(
        "user1@example.com", "user2@example.com", "user3@example.com", "user4@example.com",
        "user5@example.com", "user6@example.com", "user7@example.com", "user8@example.com",
        "user9@example.com", "user10@example.com", "user11@example.com", "user12@example.com",
        "user13@example.com", "user14@example.com", "user15@example.com", "user16@example.com",
        "user17@example.com", "user18@example.com", "user19@example.com", "user20@example.com"
    )

    private val flags = listOf("NEW", "READ", "RES")

    private val views = listOf(
        "All Pending", "All Junk", "Assigned to me", "All Complete", "Unassigned",
        "Completed by me", "Created by me"
    )

    private fun getRandomDate(): String {
        val calendar = GregorianCalendar()
        calendar.timeInMillis = System.currentTimeMillis() - Random.nextLong(0, 365L * 24 * 60 * 60 * 1000)
        return "${calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())} ${calendar.get(Calendar.DAY_OF_MONTH)}"
    }

    val data: List<Ticket> get() {
        val tempList: MutableList<Ticket> = ArrayList()
        for (i in 1..20) {
            val email = emails.random()
            val subject = subjects.random()
            val flag = flags.random()
            val date = getRandomDate()
            val view = views.random()
            tempList.add(Ticket(i, email, subject, flag, date, view))
        }
        return tempList
    }
}

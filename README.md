# Reminder

A Java desktop Application with MySQL database for creating custom reminders.

### Prerequisites

1) Mysql
2) JAVA 8

###  Getting Started(Installation) 

1) Import remainderdb.sql to the Mysql database, I used XAMPP as my Server.
2) In the file dbcon.java, change the server url to your configuration.
*  java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/remainderdb", "root", "");
3) If any error appear, check all the jar files in the Extra Jar folder, which is added to the project.


## Running the tests
1) After Configuring the system correctly, run the reminder.java file.
2) It will take you to the reminder page and at the same time, the  scheduler's job thread start and runs in background.
3) There are three buttons on the reminder page, one to create Reminder,update Reminder and to delete reminder.
4) When you click on  add button, it will take you add Reminder page where you can add reminder.
5) When you click on update Reminder button, it will take you update Reminder page where you can update  reminder
6)when you select the row in the table view and then click delete, it will delete the corresponding row from the database.
7)A list box is there at the left hand side of the window we will get sortded table view based on the values in the database table.
8)Note: Reminder is checked evey minute, so the reminder notification can be triggered at any second of the set time.




## Built With

* Netbeans 8.1
* Mysql Database
* Scheduler for running Job (Check database every 1 minute for reminder)




## Authors

* **Jince Michael** - 



## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

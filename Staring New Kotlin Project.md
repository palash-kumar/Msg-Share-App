### Android Studion - Starting New Project With Kotlin
Ref: [ Smartherd-YouTube](https://www.youtube.com/watch?v=XNFz97zqN-E&list=PLlxmoA0rQ-Lw5k_QCqVl3rsoJOnb_00UV&index=22)
Ref: [ Smartherd-GitHub](https://github.com/smartherd/MsgShareApp)

Open Android Studio -> Start a new android project
![Create New Project](https://github.com/palash-kumar/Msg-Share-App/blob/master/md-images/new_project_2.png "Create New Project")
fig -Create New Project

Than select target devices for which the app is being developed
![Select Target Device](https://github.com/palash-kumar/Msg-Share-App/blob/master/md-images/select_device_1.png "Select Target Device")
fig - Select Target Device

check *Include Kotlin Support*

then select activity type for your app, basically the template for your applicationo
![Select Application Type](https://github.com/palash-kumar/Msg-Share-App/blob/master/md-images/select_type_of_application.png "Select Application Type")
fig - Select Application Type

Then name the activity and layout file. 
![Configure Activity](https://github.com/palash-kumar/Msg-Share-App/blob/master/md-images/configure_activity.png "Configure Activity")
fig - Configure Activity

Click *Finish* to create the project:
> NOTE: Project name should be completely Unique.

### Exploring the MainActivity

MainActivity is the screen or display of an application which is showed on the startup of the application. An application can contain several activities. such as Login, Registration, List etc. And every activity requires a seperate activity class to controll all the activities of a screen. In this sectiion we will be discussing very basics of an activity which is required for every activity in an application. For the explanation we will be using MainActivity.kt as the sample code.

> NOTE: An **Activity** represents only one screen of the application.

```java
//MainActivity.kt
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
```
##### Explanation: 
The above code is from **MainActivity.kt** class. We will be extending **AppCompatActivity()** to our **MainActivity.kt** to add functionalities in our MainActivity class. 

As to see the screen of our app we are to create the screen with the contents related to *MainActivity* therefore *onCreate(savedInstanceState: Bundle?){}* will be used to create our activity screen.

To create our activity screen we will be needing a layout which is located in *res > layout* directory. While Creating our app we have provided a name for our Activity and a layout of which activity class will be created in *java* directory and the layout will be generated in *res > layout* directory. So now we will liunk our MainActivity to our layout which is *res > layout > activity_main.xml*.

In the code we have linked out *activity_main.xml* to our *MainActivity* through **setContentView(R.layout.activity_main)**

##### Syntax to check log in application end and in console

In the Application or client side **Toast** is used to show any message to the user. In development **Toast** can be used to check the data in the frontend as **Alert** is used in web application. 
```java
Toast.makeText(this, "Button was clicked!!",Toast.LENGTH_SHORT).show();
```

For backend we will be using **Log** to print our values or statements to the IDE console to monitor or check operations or results of the backend code. 
```java
Log.i("MainActivity", "Button was clicked");
```

### Navigating between Activities and sending data from one activity to another.

In this section we will be discussing on navigating from mainactivity or any other activity to another activity, and transfering data from one activity to another while navigating. 

To Navigate from one activity to another activity we require to use **Intent**. Where **Intent** is defined as *Intention of doing something*. There are two types of *Intent* :
    1 - Explicit = The target Activity is known
    2 - Implicit = Target Activity is not known

Here we have implemented *Explicit Intent* as we know the target Activity which is **SecondActivity.kt or SecondActivity**. The codeblock to create an *Intent* : 
```java
val intent = Intent(this, SecondActivity::class.java);

startActivity(intent);
```
Then using **startActivity(intent);** we navigate to next activity which was initialized through *intent*.

Now, to get a message from user end or from activity layout in **.kt** class we use the following method:
```java
val message: String = userMessage.text.toString();
```
The flow of sending values to one activity to another.
#1 - The layout where the user inputs the value or text:

```xml
<!-- activity_main.xml -->
<EditText
        android:id="@+id/userMessage"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="340dp"
        android:ems="10"
        android:hint="@string/enterMessage"
        android:inputType="text"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="LabelFor"
        tools:layout_editor_absoluteX="99dp" />
```

#2 - The value is received in Kotlin class or Java class in the following method:

```java
//MainActivity.kt

val message: String = userMessage.text.toString();

val intent = Intent(this, SecondActivity::class.java);

intent.putExtra("user_message", message);
```
Where *message* is a *val* which is *string* type to hold the value from the layout; using **userMessage.text.toString()** requesting for the value from the layout or user end. Where *userMessage* is the ID of the textfield on the layout as shown in point **#1**. Then set the value to the intent **intent.putExtra("user_message", message);** as key pair. 

#3 - Receiving the value in the next activity
```java
//SecondActivity.kt

val bundle: Bundle? =  intent.extras

bundle?.let {
    // Now with ?. if the bundle is null the following codes will not be executed preventing null pointer exception or arbitrary text such as "null"
    // val message = bundle!!.getString("user_message")

    // Here we are calling the same message but using the constant key
    val message = bundle!!.getString(Constants.USER_MSG_KEY)

    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    viewUserMessage.text = message;
}
```
In **SecondActivity.kt** we recieve all the values or parameters through **Bundle** as initiated by *val bundle: Bundle? =  intent.extras* then extract the values from the *val bundle*. Get the parameter from *bundle* value through **bundle!!.getString(Constants.USER_MSG_KEY)**, than set the value to the layout which represents **SecondActivity.kt** by **viewUserMessage.text = message;** where *viewUserMessage* is the text field ID in **activity_second.xml** layout.


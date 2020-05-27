### 5.1 String localization with kotilin
Ref: [ Smartherd-YouTube](https://www.youtube.com/watch?v=XNFz97zqN-E&list=PLlxmoA0rQ-Lw5k_QCqVl3rsoJOnb_00UV&index=22)
Ref: [ Smartherd-GitHub](https://github.com/smartherd/MsgShareApp)


String localization is required to load the app and it's content's according to native settings.
If the developed app is installed in any device therefore the app content is required to be loaded
in native language - generally which is selected from phone's settings -> languages. Therefore we are 
required to include the language contents so that the app's language supports the lagauage at which 
user is using the phone. 
> Eg: if the user changes phone language to french instead of English so the app's language is also have to be changed to frech.

> In this section we will go through steps which will allow us to know how to configure our application to support multiple languages. 

```
Project Structure (Only required directories are mapped)

MsgShareApp
|-app
|   |-main
|   |   |-java
|   |   |   |-com.smartherd.msgshareapp
|   |   |       |-activities
|   |   |       |-adapters
|   |   |       |-models
|   |   |
|   |   |-res
            |-layouts (contains the layout for activites, adapters or simply we can say for our application)
            |   |-activity_hobbies.xml
            |   |-activity_main.xml
            |   |-activity_second.xml
            |   |-list_item.xml
            |
            |
            |-values (contains all the resouces for styling, themes and template styles)
                |-colors.xml (colors are defined)
                |-strings.xml (Strings are defined)
                |-styles.xml (Thymes or stylings are done here)

```

#### Localizing String

currently in our application is harcoded which are visible to the user end shown in the following. which reppresents the property for a button. from the following codeblock we can see that *android:text="Send message to next Activity"*

```xml
<Button
        android:id="@+id/btnSendMessageToNextActivity"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="400dp"
        android:text="Send message to next Activity"
        app:layout_constraintTop_toBottomOf="@+id/userMessage"
        tools:layout_editor_absoluteX="80dp" />
```

The above procdure or style has two problems to begin with:
    1 - When creating configuration variations you have to repeat actual text, also when updating or making changes in the text we have to find it everywhere and change them one by one.
    2 - The app cannot be translated to other languages by just adding new translations for existing string resources.

So to fix above mentioned two issues we can make changes in *res -> values ->strings.xml* where instead of using hardcoded text in **android:text=** we can localize the string through *strings.xml* file.

procedure of making the changes:
    1- create and give a name to <string> tag. ```xml <string name="sendMessageToNextActivity">Send message to next Activity</string>```
    2- declare it to layout file where it is required. Now our *android:text="Send message to next Activity"* will look like *android:text="@string/sendMessageToNextActivity"*

> NOTE: *android:text="@string/sendMessageToNextActivity"* in this tag *@string* asks look in string file */sendMessageToNextActivity* is the id of the tag declared in *strings.xml*

With this our first issue is solved. Now solution to problem 2:
    1- *res -> new -> Android Resource File*
    2- select*Locale* from available qualifiers 
    3- click on the arrow *>>* -> select language (the language you want to include to your app)
    4- Select the *region* prefereably *all Region* as we expect our user can be in any region and can use the selected language.
    5- provide name for the file generally we use *strings.xml* as the file will be seperated under a seperate folder which will contain the language name. then click *ok*

Next step is to translate the string tags for frech or other prefered languages to do that we will be copying our tags from *values > strings.xaml* to *values-fr > strings.xml* and replace the text with trnaslated text; But the ID / name of the tag's should not be changed it will remain same for all the files generated for supporting different laguages.

Till now we have been modifying the text's for the .xml files for view end. Now we will be localizing the strings for .kt or kotlin files which will be runnig in our backend. Specifically the messages which will be shown to to the user end one such example is Toast messages.

In backend file **MainActivity.xml**  contains toast message *Toast.makeText(this, "Button was clicked!!",Toast.LENGTH_SHORT).show();*. Here we can see that *"Button was clicked!!"* message is hardcoded. Therefore to make the toast message show in native laguage of the user whe have to make the **string loacle** using *strings.xml* file. 

Steps: 
    1- create a tag for the toast message *Button was clicked!!* -> ```xml <string name="buttonClickedMessage">Button was clicked!!</string>```
    2- copy the tag to rest of the *strings.xml* files and translate the texts to the languages.

Accecssing the strings in .kt (kotlin) files form the *strings.xml* file. to do so we have to modify our code in the following manner. 
Replace the text *Button was clicked!!* in .kt file with 
```xml 
resources.getString(R.string.buttonWasClicked)
```

### 5.2 Updating Launcher Icon

```
Project Structure (Only required directories are mapped)

MsgShareApp
|-app
|   |-main
|   |   |-java
|   |   |
|   |   |-res
            |-mipmap
                |-ic_launcher   // Contains launcher icons for android nudget 7.1.1 and below it
                |-ic_launcher_round // Contains launcher icons for android oreo 8.1.x and onward

```

*right click on *mipmap* select *new > image asset* now from *Icon Type select > Launcher Icons (Adaptive and Legacy)* as we are launching our app for android version above 8.x.x. Then provide a name for the icon. Select or change the icon and colors as you prefer than click finish. After clicking finish two new folder will be created under *mipmap* for this project we have named our icon *shareapp* 

```
Project Structure (Only required directories are mapped)

MsgShareApp
|-app
|   |-main
|   |   |-java
|   |   |
|   |   |-res
            |-mipmap
                |-ic_launcher   // Contains launcher icons for android nudget 7.1.1 and below it
                |-ic_launcher_round // Contains launcher icons for android oreo 8.1.x and onward
                |-ic_launcher_shareapp   // our icon file for android nudget 7.1.1 and below it
                |-ic_launcher_shareapp_round // our icon file for android oreo 8.1.x and onward

```

>NOTE: File-based resource names must contain only lowercase a-z, 0-9, or underscore

As we have created our icon now it's time to show our app where is the icon allocated. For which we have to edit our **AndroidManifest.xml** 
Change the followinf lines
```xml
android:icon="@mipmap/ic_launcher"
android:roundIcon="@mipmap/ic_launcher_round"
```
to
```xml
android:icon="@mipmap/ic_launcher_shareapp"
android:roundIcon="@mipmap/ic_launcher_shareapp_round"
```

Thus our app Icon is update.

### 5.3 Applying Material Design

From the main menu goto *Tools > Theme Editor* which will launch a seperate standalone Theme Editor which will enable you to select colors for the application (Available in older version of Android Studio)

In **AndroidManifest.xml** following *android:theme="@style/AppTheme">* line contains the theme for the application. here *@style/AppTheme* represents that current heme which is being used for our application is in *style.xml* file and **id** of the theme is *AppTheme*.

```xml
<!-- styles.xml -->
<!-- Base application theme. -->
<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
    <!-- Customize your theme here. -->
    <item name="colorPrimary">@color/colorPrimary</item>
    <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
    <item name="colorAccent">@color/colorAccent</item>
</style>
```

From the above code we can see that *AppTheme* is defined and colors related to the theme is enclosed within the **<style>...</style>** tag. 
The colors for the **<items>** are defined in the **colors.xml** file.

>NOTE: In a theme *colorPrimary, colorPrimaryDark, colorAccent* are basics. And the **tint** of colorPrimary is 500, colorPrimaryDark is 700 and colorAccent can be any color as user preference. 

### 5.3 Applying Material Design Theme

In this section we will be dealing with **styles.xml** file. In the file from the tag *<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar"* parent is set to **Theme.AppCompat.Light.DarkActionBar** which can be changed to **Theme.AppCompat.Light.NoActionBar** the difference between these two is that *DarkActionBar* shows the navigation or toolbar at the top of the application, and *NoActionBar* does not shows any navigation or toolbar at the top of the application.

Now, in Android studio there are many themes which can be accessed through *AppTheme* in layout design toolbar. 


### 6 Creating APK (Android Application Package or Android Package)

https://www.youtube.com/watch?v=nSBUPuxctzA&list=PLlxmoA0rQ-Lw5k_QCqVl3rsoJOnb_00UV&index=27

1. From main toolbar goto *Build > Generate Signed APK* then select application module which is generally is **app** then *next*.
2. Next make a keystore by providing the required information and click *next*. 
3. Then select *release* from dropdown and the check box for *v1* and *v2* which represents the jar and apk signature and click finish.

>NOTE: The *key store* file generated in step #2 is very importent. And be kept safely, this file is proved as the ownership of the apk or applcation on the playstore, also this file is required to **UPDATE** the application on playstore. 
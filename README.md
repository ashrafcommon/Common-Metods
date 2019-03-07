# Common-Metods

Q) Why to use this?

A) Here you get different type of android library which helps you in android development. Here i will update all the commonly used methods


# How to Add in your project
if you are using Gradle the add this line in your app build.gradle

```
implementation 'com.ashraf:commonmethod:0.0.1'
```

In android-stdio versions(above 2.1) , jcenter() is included by default.
Kindly cross check your project level build.gredle, if jcenter() is not added then add these lines in project level build.gradle

```
allprojects {
    repositories {
        jcenter()
    }
}
```

If you are using Maven

```
<dependency>
  <groupId>com.ashraf</groupId>
  <artifactId>commonmethod</artifactId>
  <version>0.0.2</version>
  <type>pom</type>
</dependency>
```

If you are using Ivy

```
<dependency org='com.ashraf' name='commonmethod' rev='0.0.2'>
  <artifact name='commonmethod' ext='pom' ></artifact>
</dependency>
```


# How to use

First initialize the library either in Application Class of Launcher Activity.

```
Helper.initialize(getApplicationContext());
```

# Usage

1) Call this method to show Toast of android
```
Helper.showMessage("This is your message");
```

2) If you want to display a Toast for long duration then call

```
Helper.showMessage("This is your message", Toast.LENGTH_LONG);
```

3) Convert dp to px

```
Helper.dpToPx(value);
```

4) Convert px to dp 

```
Helper.pxToDp(value);
```

5) Change the first letter to caps of any String

```
Helper.firstLetterCaps(string);
```

# Custom Utils

[![Release](https://jitpack.io/v/jitpack/android-example.svg)](https://jitpack.io/#radhsyn83/radhcustomutils)

# Getting Started

Add this to your dependencies.

```gradle
dependencies {
  implementation 'com.github.radhsyn83:radhcustomutils:0.2.3'
}
```

# #Form Validation
#### Function
```java
RadhUtils().formValidation(/*Context*/, /*ArrayList<FormValidationModel>*/, /*FormValidationListener*/)
```
#### Model
```java
FormValidationModel(/*EditText*/, /*MinLenght (int)*/)
```
#### Listener
```java
FormValidationListener{
    override fun onInvalid(msg: String?) {
        // Invalid message here
    }

    override fun onValid() {
        // Valid message here
    }
})
```
#### Example

```java
val formValidation = arrayListOf<FormValidationModel>()
val fullName = findViewById<EditText>(R.id.et_full_name)
val phone = findViewById<EditText>(R.id.et_phone)

formValidation.add(FormValidationModel(et_full_name, resources.getString(R.string.form_full_name), 3))
formValidation.add(FormValidationModel(et_phone, resources.getString(R.string.form_phone), 8))

RadhUtils().formValidation(ctx, formValidation, object : FormValidationListener{
    override fun onInvalid(msg: String?) {
        toast("Error: " + msg.toString())
    }

    override fun onValid() {
        toast("Success")
    }
})
```

/* doesn't work with source level 1.8:
module com.tamagotchi {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.tamagotchi to javafx.fxml;
    exports com.tamagotchi;
}

<*/
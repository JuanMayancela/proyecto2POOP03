module com.mycompany.mavenproject3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.media;

    opens com.mycompany.mavenproject3 to javafx.fxml;
    exports com.mycompany.mavenproject3;
}

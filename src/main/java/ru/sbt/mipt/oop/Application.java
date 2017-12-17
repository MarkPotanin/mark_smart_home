package ru.sbt.mipt.oop;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class  Application {

    public static void main(String... args)
        throws IOException, TransformerException, ParserConfigurationException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        SensorEventObserver sensorEventObserver = (SensorEventObserver) ctx.getBean("sensorEventObserver");
        sensorEventObserver.observe();
        WriterCSV writerCSV = (WriterCSV) ctx.getBean("writerCSV");
        writerCSV.write();
    }

    static void handleCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

}

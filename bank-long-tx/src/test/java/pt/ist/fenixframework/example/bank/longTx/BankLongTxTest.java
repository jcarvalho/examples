package pt.ist.fenixframework.example.bank.longTx;

import java.util.concurrent.atomic.AtomicLong;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.fenixframework.example.bank.domain.Bank;

@RunWith(JUnit4.class)
public class BankLongTxTest {

    private static final Logger logger = LoggerFactory.getLogger(BankLongTxTest.class);

    private static final AtomicLong time = new AtomicLong(0);

    private static final int numIterations = 10 * 1000;

    @BeforeClass
    public static void setup() {
        bootstrap();
    }

    private static Bank bank = null;

    @Atomic
    private static void bootstrap() {
        bank = new Bank();
        FenixFramework.getDomainRoot().setBank(bank);
        for (int i = 0; i < 20; i++) {
            bank.createCustomer("Cliente " + i);
        }
    }

    @AfterClass
    public static void printResults() {
        long timePerRun = time.get() / numIterations;
        logger.info("Average time: " + timePerRun);
    }

    @Test
    public void runTests() {

    }
}

package www.Bruteforce;

import static java.lang.System.err;
import static java.lang.System.out;
import java.util.ArrayList;

public class ThreadMaster {
    
    private int amountOfThreads;
    private int scopeOfWorkForASingleThread;    
    private int remainderThread; //not all the amount of work could be divided into equal parts
    private int start;
    private ArrayList<String> codes;
    private int lastCodeIndex;
    private Thread[] bots;

    //parameterized constructor
    public ThreadMaster(int amountOfThreads, ArrayList<String> customCodes) {        
        this.start = 0;
        this.codes = customCodes;
        this.amountOfThreads = amountOfThreads;
        this.lastCodeIndex = codes.size() - 1;
        this.remainderThread = codes.size() % amountOfThreads;
        this.scopeOfWorkForASingleThread 
                = codes.size()/amountOfThreads;
    }

    public void runThreads() {        
    	createBotsArray();
    	populateBotsArray();
    	makeBotsJoinTheirThreads();
        // if there are any codes that are still remain to be tested  - 
        // this last bot/thread will take care of them 
        runRemainderBot();
    }
    
    private void createBotsArray() {
    	do {
            bots = new Thread[amountOfThreads];
            out.println("Bots array is created");
        } while (bots.length != amountOfThreads);
    }
    
    private void populateBotsArray() {
    	for (int j = 0; j <= amountOfThreads - 1;) {
            int finish = start + scopeOfWorkForASingleThread;
            try {
                bots[j] = new Thread(new BruteforceBot(start, finish, codes));
                out.println("Bots array is populated");
            } catch (Exception e) {
                err.println("Putting a bot into a theads array failed");
                continue;
            }
            bots[j].start();
            start = finish;
            j++;
        }
    }
    
    public void makeBotsJoinTheirThreads() {
    	try {
            for (int j = 0; j <= amountOfThreads - 1; j++) {
                bots[j].join();
            }
            out.println("All the Bots have joined their threads");
        } catch (InterruptedException ie) {
            err.println("InterruptedException has occured "
                    + "while a Bot was joining a thread ...");
            return;
        }
    }
    
    private void runRemainderBot() {
    	if (remainderThread != 0) {
            try {
                int remainderStart = lastCodeIndex - remainderThread;
                int remainderFinish = lastCodeIndex;
                BruteforceBot remainderBot
                        = new BruteforceBot(remainderStart, remainderFinish, codes);
                remainderBot.start();
                remainderBot.join();
            } catch (InterruptedException ie) {
                err.println("The remainder Bot has failed to "
                        + "create or start or join a thread ...");
                return;
            }
        }
    }
    
    //used for unit tests
    public int getScopeOfWorkForASingleThread() {
        return scopeOfWorkForASingleThread;
    }
    
}

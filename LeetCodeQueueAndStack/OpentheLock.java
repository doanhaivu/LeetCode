package LeetCode.LeetCodeQueueAndStack;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OpentheLock {

    public int openLock(String[] deadends, String target) {
        Set<String> aSet = new HashSet<>();
        for (String aString:deadends) {
            if (aString.equals("0000")) return -1;
            aSet.add(aString);
        }

        Set<String> visited = new HashSet<>();

        LinkedList<String> aQueue = new LinkedList<>();
        aQueue.offer("0000");
        int count = 0;

        String candidateString;

        while (!aQueue.isEmpty()) {
            int size = aQueue.size();
            for (int l = 0; l < size; l++) {
                String innerString = aQueue.pop();
                if (innerString.equals(target))
                    return count;
                for(int i = 0; i < 4; i++) {
                    int tmpInt = Character.digit(innerString.charAt(i), 10);
                    int nextInt = tmpInt+1 > 9?0:tmpInt+1;

                    char charForDigit = Character.forDigit(nextInt, 10);

                    candidateString = replaceCharUsingCharArray(innerString, charForDigit, i);
                    if (candidateString.equals(target))
                        return ++count;
                    if (!aSet.contains(candidateString) && !visited.contains(candidateString)) {
                        aQueue.offer(candidateString);
                        visited.add(candidateString);
                    }

                    nextInt = tmpInt-1 < 0?9:tmpInt-1;
                    charForDigit = Character.forDigit(nextInt, 10);

                    candidateString = replaceCharUsingCharArray(innerString, charForDigit, i);
                    if (candidateString.equals(target))
                        return ++count;
                    if (!aSet.contains(candidateString) && !visited.contains(candidateString)) {
                        aQueue.offer(candidateString);
                        visited.add(candidateString);
                    }
                }
            }

            count++;
        }

        return -1;
    }

    public String replaceCharUsingCharArray(String str, char ch, int index) {
        char[] chars = str.toCharArray();
        chars[index] = ch;
        return String.valueOf(chars);
    }


    @Test
    public void test() {
        String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
        String target = "0202";
        assertThat(openLock(deadends, target), is(6));

        deadends = new String[] {"8888"};
        target = "0009";
        assertThat(openLock(deadends, target), is(1));

        deadends = new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"};
        target = "8888";
        assertThat(openLock(deadends, target), is(-1));

        deadends = new String[] {"0000"};
        target = "8888";
        assertThat(openLock(deadends, target), is(-1));

    }
}

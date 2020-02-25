```java
public String longestPalindrome(String s) {
        if ("".equals(s)) {
            return "";
        }
        int len = 2;
        char newArr[] = new char[2 * s.length() + 3];
        newArr[0] = '$';
        newArr[1] = '#';

        for (char c : s.toCharArray()) {
            newArr[len++] = c;
            newArr[len++] = '#';
        }
        newArr[len] = '\0';
        int[] p = new int[2 * s.length() + 3];
        int max = 0;
        int id = 0;
        int maxIndex = 0;
        int maxLen = 0;
        for (int i = 1; i < len; i++) {
            if ((i < max)) {
                p[i] = Math.min(p[2 * id - i], max - i);
            } else {
                p[i] = 1;
            }
            while (newArr[i - p[i]] == newArr[i + p[i]]) {
                p[i]++;
            }

            if (max < i + p[i]) {
                id = i;
                max = i + p[i];
            }
            if (p[i] - 1 > maxLen) {
                maxLen = p[i] - 1;
                maxIndex = i;
            }
        }
        String result = String.valueOf(Arrays.copyOfRange(newArr, maxIndex - p[maxIndex] + 1, maxIndex + p[maxIndex]));
        return result.replace("#", "").replace("$", "");
    }
    ```

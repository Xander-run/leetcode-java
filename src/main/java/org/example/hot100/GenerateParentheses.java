package org.example.hot100;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        dfs(ret, "", 0, 0, n);
        return ret;
    }

    public void dfs(List<String> ret, String string, int open, int close, int n) {
        if (string.length() == n * 2) {
            ret.add(string);
            return;
        }

        if (open < n) {
            dfs(ret, string + "(", open + 1, close, n);
        }
        if (open > close) {
            dfs(ret, string + ")", open, close + 1, n);
        }
    }
}

package org.example.disjointset;

import com.sun.source.tree.Tree;

import java.util.*;

public class AccountsMerge {

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> acc2parent = new HashMap<>();
        Map<String, String> acc2owner = new HashMap<>();
        Map<String, Set<String>> acc2union = new HashMap<>();

        // initialize
        for (List<String> accs : accounts) {
            String owner = null;
            int index = 0;
            for (String acc : accs) {
                if (index == 0) {
                    owner = acc;
                } else {
                    acc2parent.put(acc, acc);
                    acc2owner.put(acc, owner);
                }
                index++;
            }
        }

        // union
        for (List<String> accs : accounts) {
            int index = 0;
            String root = null;
            for (String acc : accs) {
                if (index == 0) {
                    // do nothing
                } else if (index == 1) {
                    root = find(acc, acc2parent);
                } else {
                    acc2parent.put(find(acc, acc2parent), root);
                }
                index++;
            }
        }

        // construct union
        for (List<String> accs : accounts) {
            int index = 0;
            String parent = null;
            for (String acc : accs) {
                if (index == 0) {
                    // do nothing
                } else if (index == 1) {
                    parent = find(acc, acc2parent);
                    if (!acc2union.containsKey(parent)) {
                        acc2union.put(parent, new TreeSet<>());
                    }
                    acc2union.get(parent).add(acc);
                } else {
                    acc2union.get(parent).add(acc);
                }
                index++;
            }
        }

        List<List<String>> ret = new LinkedList<>();
        for (String parent : acc2union.keySet()) {
            List<String> emails = new LinkedList<>(acc2union.get(parent));
            Collections.sort(emails);
            emails.add(0, acc2owner.get(parent));
            ret.add(emails);
        }

        return ret;
    }

    private static String find(String acc, Map<String, String> acc2parent) {
        String currentParent = acc2parent.get(acc);
        if (currentParent.equals(acc)) {
            return acc;
        } else {
            String ret = find(currentParent, acc2parent);
            acc2parent.put(acc, ret);
            return ret;
        }
    }

    public static void main(String[] args) {
//        List<List<String>> accounts0 = new LinkedList<>();
//        accounts0.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
//        accounts0.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
//        accounts0.add(Arrays.asList("Mary","mary@mail.com"));
//        accounts0.add(Arrays.asList("John","johnnybravo@mail.com"));
//        accountsMerge(accounts0);
//
//        List<List<String>> accounts1 = new LinkedList<>();
//        accounts1.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"));
//        accounts1.add(Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"));
//        accounts1.add(Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"));
//        accounts1.add(Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"));
//        accounts1.add(Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"));
//        accountsMerge(accounts1);

        List<List<String>> accounts2 = new LinkedList<>();
        accounts2.add(Arrays.asList("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"));
        accounts2.add(Arrays.asList("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"));
        accounts2.add(Arrays.asList("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"));
        accounts2.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"));
        accounts2.add(Arrays.asList("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"));
        accountsMerge(accounts2);
    }
}

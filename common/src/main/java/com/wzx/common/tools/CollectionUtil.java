package com.wzx.common.tools;



import java.util.*;

public class CollectionUtil {

    public static boolean isEmpty(Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * 判断Collection是否不为空
     *
     * @param collection
     * @return
     */
    static public boolean notEmpty(Collection<?> collection) {
        return !empty(collection);
    }

    /**
     * 判断Map是否不为空
     *
     *
     * @param map
     * @return
     */
    static public boolean notEmpty(Map<?,?> map) {
        return !empty(map);
    }

    /**
     * 判断Object[]是否不为空
     *
     *
     * @param os
     * @return
     */
    static public boolean notEmpty(Object[] os) {
        return !empty(os);
    }

    public static boolean empty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean empty(Map<?,?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean empty(Object[] os) {
        return os == null || os.length == 0;
    }

    /**
     * 把Iterator转换为List
     *
     * @param it
     *            Iterator
     * @return List
     */
    public static List toList(Iterator it) {
        ArrayList<Object> r = new ArrayList<Object>();
        while (it.hasNext()) {
            r.add(it.next());
        }
        return r;
    }



    /**
     * 合并两个List的数据,只保留相同的数据.就是两个集合的交集<br>
     * <code>
     * lst1 : [1,2,3] <br>
     * lst2 : [2,3]<br>
     * uninonList result is [2,3]</code>
     *
     * @param <V>
     * @param lst1
     * @param lst2
     * @return
     */
    public static <V> List<V> unionList(List<V> lst1, List<V> lst2) {
        List<V> lst = new ArrayList<V>();

        if (lst1 == null && lst2 == null) {
            return lst;
        }
        if (lst1 == null) {
            return lst2;
        }
        if (lst2 == null) {
            return lst1;
        }

        for (V v : lst1) {
            if (lst2.contains(v)) {
                lst.add(v);
            }
        }
        return lst;
    }

    /**
     * 交集两个List的数据,只保留相同的数据.就是两个集合的交集<br>
     * <code>
     * lst1 : [1,2,3] <br>
     * lst2 : [2,3]<br>
     * uninonList result is [2,3]</code>
     *
     * @param <V>
     * @param lst1
     * @param lst2
     * @return
     */
    public static <V> List<V> intersectList(List<V> lst1, List<V> lst2) {
        List<V> lst = new ArrayList<V>();

        if (lst1 == null && lst2 == null) {
            return lst;
        }
        if (lst1 == null) {
            return lst2;
        }
        if (lst2 == null) {
            return lst1;
        }

        for (V v : lst1) {
            if (lst2.contains(v)) {
                lst.add(v);
            }
        }
        return lst;
    }


    /**
     * 合并两个List的数据,只保留相同的数据.就是两个集合的交集<br>
     * <code>
     * lst1 : [1,2,3] <br>
     * lst2 : [2,3]<br>
     * uninonList result is [2,3]</code>
     *
     * @param <V>
     * @param lst1
     * @param lst2
     * @return
     */
    public static <V> Collection<V> addCollection(Collection<V> lst1,
                                                  Collection<V> lst2) {
        List<V> lst = new ArrayList<V>();

        if (lst1 == null && lst2 == null) {
            return lst;
        }
        if (lst1 == null) {
            return lst2;
        }
        if (lst2 == null) {
            return lst1;
        }

        lst.addAll(lst1);
        for (V v : lst2) {
            if (!lst1.contains(v)) {
                lst.add(v);
            }
        }
        return lst;
    }

    /**
     * 移除lst2在lst1中的数据<br>
     *
     * @param <V>
     * @param lst1
     * @param lst2
     * @return
     */
    public static <V> List<V> remove(List<V> lst1, List<V> lst2) {
        List<V> lst = new ArrayList<V>();

        if (isEmpty(lst1) && isEmpty(lst2)) {
            return lst;
        }

        if (isEmpty(lst1)) {
            return lst1;
        }

        if (isEmpty(lst2)) {
            return lst1;
        }

        for (V v : lst1) {
            if (!lst2.contains(v)) {
                lst.add(v);
            }
        }
        return lst;
    }

    public static <V> List<V> itToList(Iterator<V> it) {
        ArrayList<V> r = new ArrayList<V>();
        while (it.hasNext()) {
            r.add(it.next());
        }
        return r;

    }

    public static void clearNull(Collection<?> lst) {
        if (lst != null) {
            Iterator<?> it = lst.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    it.remove();
                }
            }
        }
    }
}

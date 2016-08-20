package ru.sbt.stream;


import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream<T> {

    private List<T> list;

    public static <T> Stream<T> of(List<T> put) {
        Stream<T> stream = new Stream<>();
        stream.list = new ArrayList<>(put);
        return stream;
    }


    public Stream<T> filter(Predicate<? super T> predicate) {
        Iterator<T> coll = list.iterator();
        while (coll.hasNext()) {
            if (!predicate.test(coll.next())) {
                coll.remove();
            }
        }
        return this;
    }

    public<R> Stream<R> transform(Function<? super T, ? extends R> function) {
        List<R> listCurrent = list.stream().map((Function<T, ? extends R>) function::apply).collect(Collectors.toList());
        Stream<R> newStream = new Stream<>();
        newStream.list = listCurrent;
        return newStream;
    }


    public<K, U> Map<K,U> toMap(Function<? super T, ? extends K> key,
                                Function<? super T, ? extends U> value) {
        Map<K, U> map = new HashMap<>();
        for (T t : list) {
            map.put(key.apply(t), value.apply(t));
        }
        return map;
    }

    public void forEach() {
        list.forEach(System.out::println);
    }

    public List<T> toList() {
        return list;
    }






}

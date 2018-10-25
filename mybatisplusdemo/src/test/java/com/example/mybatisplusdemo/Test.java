package com.example.mybatisplusdemo;

import java.util.*;
import java.util.function.Consumer;

public class Test {

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        public final int size() {
            return HashMap.this.size;
        }

        public final void clear() {
            HashMap.this.clear();
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return HashMap.this.new EntryIterator();
        }

        public final boolean contains(Object var1) {
            if (!(var1 instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry var2 = (Map.Entry)var1;
                Object var3 = var2.getKey();
                HashMap.Node var4 = HashMap.this.getNode(HashMap.hash(var3), var3);
                return var4 != null && var4.equals(var2);
            }
        }

        public final boolean remove(Object var1) {
            if (var1 instanceof Map.Entry) {
                Map.Entry var2 = (Map.Entry)var1;
                Object var3 = var2.getKey();
                Object var4 = var2.getValue();
                return HashMap.this.removeNode(HashMap.hash(var3), var3, var4, true, true) != null;
            } else {
                return false;
            }
        }

        public final Spliterator<Map.Entry<K, V>> spliterator() {
            return new HashMap.EntrySpliterator(HashMap.this, 0, -1, 0, 0);
        }

        public final void forEach(Consumer<? super Map.Entry<K, V>> var1) {
            if (var1 == null) {
                throw new NullPointerException();
            } else {
                if (HashMap.this.size > 0) {
                    HashMap.Node[] var2 = HashMap.this.table;
                    if (HashMap.this.table != null) {
                        int var3 = HashMap.this.modCount;

                        for(int var4 = 0; var4 < var2.length; ++var4) {
                            for(HashMap.Node var5 = var2[var4]; var5 != null; var5 = var5.next) {
                                var1.accept(var5);
                            }
                        }

                        if (HashMap.this.modCount != var3) {
                            throw new ConcurrentModificationException();
                        }
                    }
                }

            }
        }
    }

    abstract class HashIterator {
        HashMap.Node<K, V> next;
        HashMap.Node<K, V> current;
        int expectedModCount;
        int index;

        HashIterator() {
            this.expectedModCount = HashMap.this.modCount;
            HashMap.Node[] var2 = HashMap.this.table;
            this.current = this.next = null;
            this.index = 0;
            if (var2 != null && HashMap.this.size > 0) {
                while(this.index < var2.length && (this.next = var2[this.index++]) == null) {
                    ;
                }
            }

        }

        public final boolean hasNext() {
            return this.next != null;
        }

        final HashMap.Node<K, V> nextNode() {
            HashMap.Node var2 = this.next;
            if (HashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else if (var2 == null) {
                throw new NoSuchElementException();
            } else {
                if ((this.next = (this.current = var2).next) == null) {
                    HashMap.Node[] var1 = HashMap.this.table;
                    if (HashMap.this.table != null) {
                        while(this.index < var1.length && (this.next = var1[this.index++]) == null) {
                            ;
                        }
                    }
                }

                return var2;
            }
        }

        public final void remove() {
            HashMap.Node var1 = this.current;
            if (var1 == null) {
                throw new IllegalStateException();
            } else if (HashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else {
                this.current = null;
                Object var2 = var1.key;
                HashMap.this.removeNode(HashMap.hash(var2), var2, (Object)null, false, false);
                this.expectedModCount = HashMap.this.modCount;
            }
        }
    }
}

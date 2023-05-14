package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        /*Disposable subscribe = ReactiveSources.intNumbersFlux().subscribe(
                number -> System.out.println(number),
                error -> System.out.println(error),
                () -> System.out.println("Complete")
        );*/

        ReactiveSources.userMono().subscribe(
                user -> System.out.println(user),
                error -> System.out.println(error),
                () -> System.out.println("Complete")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscription<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscription<T> extends BaseSubscriber<T> {
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened");
        request(1);
    }

    public void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        request(1);
    }

    public void hookOnComplete() {
        System.out.println("Complete");
    }
}


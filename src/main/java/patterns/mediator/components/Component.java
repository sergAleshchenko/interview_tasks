package patterns.mediator.components;

import patterns.mediator.mediators.Mediator;

/**
 * @author Sergei Aleshchenko
 */
public interface Component {
    void setMediator(Mediator mediator);

    String getName();
}

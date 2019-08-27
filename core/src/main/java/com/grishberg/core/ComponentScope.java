package com.grishberg.core;

/**
 * Implementation must be light-weight object that knows when scope-object initialized.
 */
public interface ComponentScope {
    /**
     * Registers action for current component.
     * Action methods can be invoked immediately, if component already initialized.
     */
    void registerComponentAction(ComponentScopeAction action);

    void unregisterComponentAction(ComponentScopeAction action);
}

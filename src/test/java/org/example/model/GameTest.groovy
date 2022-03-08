package org.example.model

import spock.lang.Specification

class GameTest extends Specification {

    def "test playing games"(){
        given:
        def gameRule = new GameRule()
        def player1 = new Player(gameRule)
        def player2 = new Player(gameRule)
        def player3 = new Player(gameRule)
        def player4 = new Player()

        def dealer = new Dealer()

        when:
        dealer.join(player1)
        dealer.join(player2)
        dealer.join(player3)
        dealer.join(player4)

        dealer.deal()

        then:
        noExceptionThrown()

    }
}

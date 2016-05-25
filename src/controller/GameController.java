package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import model.Game;
import model.HumanPlayer;
import view.GameView;

/**
 *
 * @author hakkahi
 *
 */
public final class GameController {

    private final GameView _view;
    private final Game _game;

    //Settings Listener
    private WindowAdapter _settingsClosingWindow;
    private ActionListener _settingsQuit;
    private ActionListener _settingsPlay;

    //Game Listener
    private MouseAdapter[][] _gameSelectColumnGrid;
    private MouseAdapter[][] _gameClickColumnGrid;
    private MouseAdapter[] _gameSelectColumnPreview;
    private MouseAdapter[] _gameClickColumnPreview;
    private WindowAdapter _gameClosingWindow;
    private ComponentAdapter _gameResizingWindow;

    //End Game Listener
    private ActionListener _endGamePlay;
    private ActionListener _endGameQuit;
    private WindowAdapter _endGameClosingWindow;

    public GameController(GameView view, Game game) {

        //On initialise la vue du controller
        this._view = view;
        this._game = game;

        initSetingsController();
        initGameController();
        initEndGameController();

    }

    public void initSetingsController() {

        this._settingsClosingWindow = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                quit();
            }

        };

        this._settingsQuit = (ActionEvent e) -> {
            quit();
        };

        this._settingsPlay = (ActionEvent e) -> {
            startGame();
        };

        this._view.getSettingsFrame().addWindowListener(_settingsClosingWindow);
        this._view.getSettingsQuitButton().addActionListener(_settingsQuit);
        this._view.getSettingsPlayButton().addActionListener(_settingsPlay);

    }

    public void initGameController() {

        //On initialise les matrices d'évènement de la partie Grid
        this._gameSelectColumnGrid = new MouseAdapter[this._game.getBoard().getHeight()][this._game.getBoard().getWidth()];
        this._gameClickColumnGrid = new MouseAdapter[this._game.getBoard().getHeight()][this._game.getBoard().getWidth()];

        //On initialise les matrices d'évènement de la partie Preview
        this._gameSelectColumnPreview = new MouseAdapter[this._game.getBoard().getWidth()];
        this._gameClickColumnPreview = new MouseAdapter[this._game.getBoard().getWidth()];

        //Création de l'évènement qui quitte le jeu lors d'un clique de la croix
        this._gameClosingWindow = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                quit();
            }

        };

        this._gameResizingWindow = new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {

                _view.setBorderSize();

            }

        };

        //Création des évènements de souris dans la partie Grid
        for (int i = 0; i < this._game.getBoard().getHeight(); ++i) {

            for (int j = 0; j < this._game.getBoard().getWidth(); ++j) {

                final int column = j;
                final int line = i;

                this._gameSelectColumnGrid[i][j] = new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent e) {

                        _game.resetPosPreview();
                        _game.setPosPreview(column);

                    }
                };

                this._gameClickColumnGrid[i][j] = new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        if (_game.getCurrentPlayer() instanceof HumanPlayer) {

                            if (_game.strokeIsValid(column)) {
                                _game.playMove(column);

                            }
                        }

                    }
                };

            }

        }

        //Création des évènements de souris dans la partie preview
        for (int i = 0; i < this._game.getBoard().getWidth(); ++i) {

            final int column = i;

            this._gameSelectColumnPreview[i] = new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {

                    _game.resetPosPreview();
                    _game.setPosPreview(column);

                }
            };

            this._gameClickColumnPreview[i] = new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    if (_game.getCurrentPlayer() instanceof HumanPlayer) {
                        _game.playMove(column);
                    }
                }
            };

        }

        //Ajout des évènements crées à leurs éléments dans la vue
        this._view.getMainFrame().addWindowListener(_gameClosingWindow);

        this._view.getMainFrame().addComponentListener(_gameResizingWindow);

        int count = 0;
        for (int i = 0; i < this._game.getBoard().getHeight(); ++i) {

            for (int j = 0; j < this._game.getBoard().getWidth(); ++j) {

                this._view.getGameGrid().getComponent(count).addMouseListener(this._gameSelectColumnGrid[i][j]);
                this._view.getGameGrid().getComponent(count).addMouseListener(this._gameClickColumnGrid[i][j]);
                count++;

            }

        }

        for (int i = 0; i < this._game.getBoard().getWidth(); ++i) {

            this._view.getGamePreview().getComponent(i).addMouseListener(this._gameSelectColumnPreview[i]);
            this._view.getGamePreview().getComponent(i).addMouseListener(this._gameClickColumnPreview[i]);

        }

    }

    public void initEndGameController() {

        this._endGameClosingWindow = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                quit();
            }

        };

        this._endGamePlay = (ActionEvent e) -> {
            playAgain();
        };
        this._endGameQuit = (ActionEvent e) -> {
            quit();
        };

        this._view.getEndGameQuit().addActionListener(_endGameQuit);
        this._view.getEndGamePlay().addActionListener(_endGamePlay);
        this._view.getEndGameFrame().addWindowListener(_gameClosingWindow);

    }

    private void quit() {
        System.exit(0);
    }

    private void playAgain() {

        this._view.getEndGameFrame().setVisible(false);
        this._view.getSettingsFrame().setVisible(true);
        this._game.resetGame();

    }

    private void startGame() {

        this._game.getBoard().setEffectChances(this._view.getSettingsTileSlider().getValue());

        this._game.setTilesEffect();

        this._view.getSettingsFrame().setVisible(false);
        this._view.setVisible(true);

    }

}

"""
    Picture is the Batmobile from the Batman Beyond series is
    Flying around the city at night. The buildings randomly generate
    to simulate the car is traveling around the city scape.

    The BatMobile can move around the the ARROW KEYS

    I couldn't upload the png file on csns so I renamed it to the 'batmobile.png.py' file
    so I could submit it. Just remove the .py from that name and it should work
"""

import random
import pygame
from building import Building
from bat_symbol import Symbol


def main():
    pygame.init()
    """ Setting the clock speed and screen size """
    FPS = 10
    DISPLAY_WIDTH = 800
    DISPLAY_HEIGHT = 600

    """Colors """
    BLACK = (0, 0, 0)
    PURPLE = (129, 54, 142)

    """
    Sets the display up and clock

        Sets the condition of the game loop while true

        Args:
            x (double) : set the starting position of the symbol
            y (int) : set the starting position of the symbol

            x_l_change (boolean): sets if key pressed is true or not
            x_r_change (boolean): sets if key pressed is true or not
            y_u_change (boolean): sets if key pressed is true or not
            y_d_change (boolean): sets if key pressed is true or not

            symbol (bat_symbol): creates the symbol
    """
    screenDisplay = pygame.display.set_mode((DISPLAY_WIDTH, DISPLAY_HEIGHT))
    pygame.display.set_caption('da Picture')
    clock = pygame.time.Clock()
    crashed = False

    # starting on center of screen
    x = DISPLAY_WIDTH * .45
    y = 40

    x_l_change = False
    x_r_change = False
    y_u_change = False
    y_d_change = False

    symbol = Symbol(x, y, screenDisplay)

    """ game loop """
    while not crashed:
        """ quiting out """
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                crashed = True
            """ event handling """
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_LEFT:
                    x_l_change = True
                if event.key == pygame.K_RIGHT:
                    x_r_change = True
                if event.key == pygame.K_UP:
                    y_u_change = True
                if event.key == pygame.K_DOWN:
                    y_d_change = True

            if event.type == pygame.KEYUP:
                if event.key == pygame.K_LEFT:
                    x_l_change = False
                if event.key == pygame.K_RIGHT:
                    x_r_change = False
                if event.key == pygame.K_UP:
                    y_u_change = False
                if event.key == pygame.K_DOWN:
                    y_d_change = False

        """ Logic to move symbol """
        if x_l_change:
            x += -30
        if x_r_change:
            x += 30
        if y_u_change:
            y += -15
        if y_d_change:
            y += 15

        """
        re-draws the background to appear that its flying around the city
        added other object to make building all uniform
        """
        screenDisplay.fill(PURPLE)
        for i in range(1, 10):
            building = Building(random.randrange(0, DISPLAY_WIDTH), DISPLAY_HEIGHT * random.random() - 10,
                                random.randrange(199, 599), BLACK)
            building.draw(screenDisplay)

        pygame.draw.rect(screenDisplay, BLACK, [0, 430, DISPLAY_WIDTH, DISPLAY_HEIGHT/3])
        pygame.draw.circle(screenDisplay, PURPLE, (random.randrange(400, 650), 180), 40, 0)
        pygame.draw.ellipse(screenDisplay, PURPLE, [random.randrange(100, 300), 200, 49, 170], 0)
        symbol.bat_symbol(x, y)

        pygame.display.update()
        clock.tick(FPS)

    pygame.quit()
    quit()

if __name__ == "__main__":
    main()

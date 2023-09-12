# bird

Boids 演算法的 processing 實現，對於人工生命程式的小探索。

## 專案結構
* Main.java : 繼承 processing，管理鳥群和處理顯示成像。
* Bird.java : 實現 Boids 演算法，根據參數決定鳥類運動速度與加速度。
* Vector2d.java : 儲存長度為二向量的 class，協助進行向量計算

以下摘自維基百科(wiki)。

https://en.wikipedia.org/wiki/Boids

Boids is an artificial life program, developed by Craig Reynolds in 1986, which simulates the flocking behaviour of birds. His paper on this topic was published in 1987 in the proceedings of the ACM SIGGRAPH conference. The name "boid" corresponds to a shortened version of "bird-oid object", which refers to a bird-like object.

As with most artificial life simulations, Boids is an example of emergent behavior; that is, the complexity of Boids arises from the interaction of individual agents (the boids, in this case) adhering to a set of simple rules. The rules applied in the simplest Boids world are as follows:

* separation: steer to avoid crowding local flockmates
* alignment: steer towards the average heading of local flockmates
* cohesion: steer to move towards the average position (center of mass) of local flockmates

More complex rules can be added, such as obstacle avoidance and goal seeking.

The basic model has been extended in several different ways since Reynolds proposed it. For instance, Delgado-Mata et al. extended the basic model to incorporate the effects of fear. Olfaction was used to transmit emotion between animals, through pheromones modelled as particles in a free expansion gas. Hartman and Benes introduced a complementary force to the alignment that they call the change of leadership. This steer defines the chance of the boid to become a leader and try to escape.

The movement of Boids can be characterized as either chaotic (splitting groups and wild behaviour) or orderly. Unexpected behaviours, such as splitting flocks and reuniting after avoiding obstacles, can be considered emergent.

The boids framework is often used in computer graphics, providing realistic-looking representations of flocks of birds and other creatures, such as schools of fish or herds of animals. It was for instance used in the 1998 video game Half-Life for the flying bird-like creatures seen at the end of the game on Xen, named "boid" in the game files.

The Boids model can be used for direct control and stabilization of teams of simple unmanned ground vehicles (UGV) or micro aerial vehicles (MAV) in swarm robotics. For stabilization of heterogeneous UAV-UGV teams, the model was adapted for using onboard relative localization by Saska et al.

At the time of proposal, Reynolds' approach represented a giant step forward compared to the traditional techniques used in computer animation for motion pictures. The first animation created with the model was Stanley and Stella in: Breaking the Ice (1987), followed by a feature film debut in Tim Burton's film Batman Returns (1992) with computer generated bat swarms and armies of penguins marching through the streets of Gotham City.

The boids model has been used for other interesting applications. It has been applied to automatically program Internet multi-channel radio stations. It has also been used for visualizing information and for optimization tasks.

Biologist Richard Dawkins references the Boids model in his 2009 book The Greatest Show on Earth: The Evidence for Evolution.

# Visual Distractions & Adaptive Automation

## Introduction and motivation
In this project a user model will be implemented that focusses on visual distractions during driving. 
The user model aims to benefit driver safety by adaptively changing the levels of automation with a change of distraction.

For this project visual objects will be placed on a driving simulation, by using eye-tracking we will be able to find which items are most distracting and give the control to an automated driving system when the visual objects cause too much distraction.
Based on these findings we hope to further increase the safety of semi-automated driver systems.

## Implementation
For this project we will be using Dario Salvucci's driving simulation in Java. In it we will implement visual distractions in the form of billboards on the right side of the highway. These billboards can either be interesting or not-interesting. The degree of distraction of the user will be measured using the eye-tracker: when there are too many fixations on the billboards, the control of the vehicle will switch from the user to the ACT-R model. This will be communicated to the user through a message on the screen. The model will always take over the driving for a certain period of time. After this, the control can be given back to the user if their attention has returned to the highway (as measured by fixations on the road). 

Meanwhile the user will be performing a 0-back task, so they will follow the current speed limit. This allows us to measure the effect of visual distraction on speed-keeping performance as well.

There are a number of design choices involved in this process. Below you will find the questions we ask ourselves and some preliminary answers.
* What will be on the billboards?
  - The interesting billboards will show text that is in some way engaging to the user. The not-interesting billboards will be plain gray.
* How frequently do the billboards appear?
  - They will appear at semi-random intervals, such as every 10 seconds ± 5 seconds.
* How large are the billboards?
  - We will base this decision on testing.
* How long does the user have to look at the billboards for it to count as a distraction?
  - We will base this decision on literature.
* How long will the model take over the driving?
  - At least a few seconds, to let the user get accustomed to the change. We will base this decision on testing.
* How will the switch in control be communicated to the user?
  - The dashboard will show the current mode of control at all times by means of two icons signifying user control and automated control. Whenever control switches one way or the other, the new icon will blink a few times on the dashboard by a beeping sound. 
* How long does the user have to look at the road to gain back control over the vehicle?
  - At least a few seconds. 

These choices are of great importance to the functioning of the system and to user satisfaction. We will base our final choices both on literature and on our testing of the system.

## Experimental setup
In our experiments, participants have to perform the 0-back task on the straight highway. They will drive for four sessions of 5 minutes:

* A practice session
* A session with light distractions
* A session with heavy distractions
* A session with mixed distractions

We will record how often the system had to take over to determine how distracted our drivers were during the sessions. Furthermore, we will measure speed-keeping performance and investigate whether it is impacted by distraction. Finally, we will examine user experience by means of a very simple questionnaire.

## Related works

## References

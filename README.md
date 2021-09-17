# Visual Distractions & Adaptive Automation

## Introduction and motivation

## Related works

## Implementation
For this project we will be using Dario Salvucci's driving simulation in Java. In it we will implement visual distractions in the form of billboards on the right side of the highway. These billboards can either be interesting (with text on them) or not interesting (plain gray). The degree of distraction of the user will be measured using the eye-tracker: when there are too many fixations on the billboards, the control of the vehicle will switch from the user to the ACT-R model. This will be communicated to the user through a message on the screen. The model will always take over the driving for a certain period of time. After this, the control can be given back to the user if their attention has returned to the highway (as measured by fixations on the road). 

Meanwhile the user will be performing a 0-back task, so they will follow the current speed limit. This allows us to measure the effect of visual distraction on speed-keeping performance as well.

There are a number of design choices involved in this process: 
* How frequently do the billboards appear?
* How large are the billboards?
* How long does the user have to look at the billboards for it to count as a distraction?
* How long will the model take over the driving?
* How will the switch in control be communicated to the user?
* How long does the user have to look at the road to gain back control over the vehicle?

These choices are of great importance to the functioning of the system and to user satisfaction. We will base our choices both on literature and on our testing of the system.

## Experiment setup
Our experiment will measure if drivers are distracted and let the ACT-R model take over as is described in the Implementation section. We will create two types of distractions: 

* A simple and boring distraction 
* A more striking and exciting distraction

We plan to do this by creating "bill boards" of a boring colour like gray and a more visually distracting like cyan.

Thus we let a participant drive for four sessions:

* A practise session
* A session with small disctractions
* A session with large distractions
* A session with mixed distractions

Afterwards we can measure how often the system had to take over to determine how distracted our drivers. 

## Hypothesis

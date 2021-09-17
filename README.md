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
Distractions have always been a key contributor in traffic accidents. A study in the area of Washington D. C. suggests that 78% of all traffic accidents and near-accidents was directly preceded by some moment of inattention (Klauer et al., 2005). There are three major types of driver distraction defined: Visual distraction, manual distraction and cognitive distraction (Liang & Lee, 2008). Visual distraction includes any movement of the eyes from the road. Manual distractions are physical, e.g. letting one hand of the steering wheel to change the radio volume. Both visual and manual distraction are therefore prominent in the external behavior of the driver. Cognitive distraction, contrarily, is any distraction that happens within the mind of the driver. Cognitive distractions are therefore not visible from the outside, but nonetheless just as dangerous as visual and manual distraction. Our implementation of the adaptive driving algorithm wil focus entirely on visual distractions.

Klauer et al. (2006) showed a significant relation between traffic incidents and both the total time of taking eyes off the road and the duration of the longest glance off the road. So the longer the eyes are averted from the road straight forward, the more likely a driver is to crash. Participants in the experiment took their eyes of the road for a mean total of 2 seconds in the last 5 seconds before a crash. The longest averted glance in those 5 seconds was on average 1.5 seconds.

An influence of glance (distraction) duration on lane departure is shown on multiple occasions (Tijerina et al. 1996; McGehee, 1994). Additionally, a study testing reaction times for braking lead vehicles also showed a significant relation between reaction time and glance (distraction) duration (Zhang et al., 2006).  They predict that an increase in glance duration of 25% may cause an increase in reaction time of 0.39s and an increase of 0.06m in lane centre deviation.

The same meta-analysis by Klauer et al. (2006) distinguished three ellipses for the location of visual distraction while driving. The first ellipse is less than 20 degrees away from the middle of the road, i.e. dashboard, left forward and right forward. The second ellipse is between 20 and 40 degrees from the centre: Centre mirror, left mirror and radio/interface. The third ellipse includes everything above 40 degrees from the centre, a hand-held object and closed eyes.

## References
Dingus, T. A., Hulse, M. C., McGehee, D. V., Manakkal, R., & Fleischman, R. N. (1994). Driver performance results from the TravTek IVHS camera car evaluation study. In        Proceedings of the Human Factors and Ergonomics Society 38th Annual Meeting (pp. 1118–1122). Santa Monica, CA: Human Factors and Ergonomics Society.

Klauer, S. G., Dingus, T. A., Neale, V. L., Sudweeks, J. D., & Ramsey, D. J. (2006). The impact of driver inattention on near-crash/crash risk: An analysis using the 100-car naturalistic driving study data.

Klauer, S. G., Neale, V. L., Dingus, T. A., Ramsey, D., & Sudweeks, J. (2005). Driver inattention: A contributing factor to crashes and near-crashes. In Proceedings of the Human Factors and Ergonomics Society Annual Meeting (Vol. 49, No. 22, pp. 1922-1926). Sage CA: Los Angeles, CA: Sage Publications.

Liang, Y., & Lee, J. D. (2008). Comparing Support Vector Machines (SVMs) and Bayesian Networks (BNs) in detecting driver cognitive distraction using eye movements. Passive eye monitoring: Algorithms, applications and experiments, 285-300.

Tijerina, L., Kiger, S., Rockwell, T., & Tornow, C. (1996). Heavy vehicle driver workload assessment Task 7A: In-cab test message system
and cellular phone use by heavy vehicle drivers on the road. Washington, DC: U.S. Department of Transportation.

Zhang, H., Smith, M. R., & Witt, G. J. (2006). Identification of real-time diagnostic measures of visual distraction with an automatic eye-tracking system. Human factors, 48(4), 805-821.

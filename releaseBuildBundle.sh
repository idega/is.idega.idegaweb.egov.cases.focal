#!/bin/sh

maven scm:update-project clean test scm:prepare-release 	        lastexit="$?" 	        #echo exited with $lastexit signal 	        if [ $lastexit -eq 0 ]; then 	                        maven iw-bundle:deploy site:deploy 	                echo Finished 	        else 	                echo Aborted 	        fi
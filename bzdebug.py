#!/usr/bin/env python

from __future__ import division, print_function
import ssl
#from parser import parser

from pdb import set_trace
# import bugzilla

from bugzilla.rhbugzilla import RHBugzilla

import sys
from datetime import datetime, timezone, timedelta

import argparse
import os

def checkArguments():
    parser = argparse.ArgumentParser(description=__file__ + ' command line arguments')
    parser.add_argument('-k', '--key', required=True, type=str, action=EnvDefault, envvar='BZ_API_KEY',
                        help='The Bugzilla API key')
    parser.add_argument('-p', '--time_delta_param', required=False, type=str, action=EnvDefault, envvar='TIME_DELTA_PARAM',
                        help='The time delta parameter: hours or days')
    parser.add_argument('-v', '--time_delta_value', required=False, type=int, action=EnvDefault, envvar='TIME_DELTA_VALUE',
                        help='The time delta value: number of [hours|days]. For hours use 1 to 23, and for days use 1 to 30.')
    args = parser.parse_args()

    #check passed arguments
    valid_time_delta_params = ['hours','days']
    valid_hours = [1,23]
    valid_days = [1,30]

    errormessage = ""

    if args.time_delta_param != None:
        if args.time_delta_param in valid_time_delta_params:
            if args.time_delta_value == None:
                    errormessage = "The time_delta_value must be specified"
            else:
                if args.time_delta_param == "hours":
                    if args.time_delta_value < valid_hours[0] or args.time_delta_value > valid_hours[1]:
                        errormessage = "For hours use values from " + str(valid_hours[0]) + " to " + str(valid_hours[1])
                else:
                    if args.time_delta_value < valid_days[0] or args.time_delta_value > valid_days[1]:
                        errormessage = "For days use values from " + str(valid_days[0]) + " to " + str(valid_days[1])
        else:
            errormessage = "Invalid time_delta_param. Valid values include: " + str(valid_time_delta_params)

    if errormessage != "":
        print(errormessage)
        parser.print_help()
        parser.exit(1)
    else:
        return args

if __name__ == "__main__":
#    main()

#def main():
#verify parameters
    try:
        #args = checkArguments()
        #in_api_key = args.key
        URL = "bugzilla.redhat.com"
        API_KEY = "NcQW4C0sQ8gCpXc3XeQD7jhYc3qzRRwO4j5McuI1"

        bzapi = RHBugzilla(url=URL,api_key=API_KEY)

        query = {
            'f1': 'cf_internal_whiteboard',
            'o1': 'anywords',
            'v1': 'mirror_to_cnv_jira',
            'include_fields':['_default','_custom','flags','external_bugs']
        }

        #query = {
        #    'bug_status': [
        #        'NEW', 'ASSIGNED', 'POST', 'MODIFIED', 'ON_QA', 'VERIFIED'
        #    ],
        #    'product':'Container Native Virtualization (CNV)',
        #    'include_fields':['_default','_custom','flags','external_bugs']
        #}

        bugs = bzapi.query(query)

        print ("Number of BZs: %s" % len(bugs))
        i = 1
        for bug in bugs:
            print(str(i) + ": [" + str(bug.id) + ", " + bug.product + ", " + bug.bug_status + ", (" + bug.cf_internal_whiteboard + ")" + "]")
            #print(bug._bug_fields)
            i = i + 1
    except Exception as e:
        print("exception in main..." + str(e))
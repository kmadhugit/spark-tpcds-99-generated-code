/* 001 */ public SpecificOrdering generate(Object[] references) {
/* 002 */   return new SpecificOrdering(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificOrdering extends org.apache.spark.sql.catalyst.expressions.codegen.BaseOrdering {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */
/* 009 */
/* 010 */   public SpecificOrdering(Object[] references) {
/* 011 */     this.references = references;
/* 012 */
/* 013 */   }
/* 014 */
/* 015 */
/* 016 */
/* 017 */   public int compare(InternalRow a, InternalRow b) {
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA;
/* 022 */     int primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull1 = i.isNullAt(0);
/* 026 */       int value1 = isNull1 ? -1 : (i.getInt(0));
/* 027 */       boolean isNull = isNull1;
/* 028 */       int value = value1;
/* 029 */       if (isNull) {
/* 030 */
/* 031 */         if (!false) {
/* 032 */           isNull = false;
/* 033 */           value = 0;
/* 034 */         }
/* 035 */       }
/* 036 */       isNullA = isNull;
/* 037 */       primitiveA = value;
/* 038 */     }
/* 039 */     i = b;
/* 040 */     boolean isNullB;
/* 041 */     int primitiveB;
/* 042 */     {
/* 043 */
/* 044 */       boolean isNull1 = i.isNullAt(0);
/* 045 */       int value1 = isNull1 ? -1 : (i.getInt(0));
/* 046 */       boolean isNull = isNull1;
/* 047 */       int value = value1;
/* 048 */       if (isNull) {
/* 049 */
/* 050 */         if (!false) {
/* 051 */           isNull = false;
/* 052 */           value = 0;
/* 053 */         }
/* 054 */       }
/* 055 */       isNullB = isNull;
/* 056 */       primitiveB = value;
/* 057 */     }
/* 058 */     if (isNullA && isNullB) {
/* 059 */       // Nothing
/* 060 */     } else if (isNullA) {
/* 061 */       return -1;
/* 062 */     } else if (isNullB) {
/* 063 */       return 1;
/* 064 */     } else {
/* 065 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 066 */       if (comp != 0) {
/* 067 */         return comp;
/* 068 */       }
/* 069 */     }
/* 070 */
/* 071 */
/* 072 */     i = a;
/* 073 */     boolean isNullA1;
/* 074 */     int primitiveA1;
/* 075 */     {
/* 076 */
/* 077 */       boolean isNull4 = i.isNullAt(1);
/* 078 */       int value4 = isNull4 ? -1 : (i.getInt(1));
/* 079 */       boolean isNull3 = isNull4;
/* 080 */       int value3 = value4;
/* 081 */       if (isNull3) {
/* 082 */
/* 083 */         if (!false) {
/* 084 */           isNull3 = false;
/* 085 */           value3 = 0;
/* 086 */         }
/* 087 */       }
/* 088 */       isNullA1 = isNull3;
/* 089 */       primitiveA1 = value3;
/* 090 */     }
/* 091 */     i = b;
/* 092 */     boolean isNullB1;
/* 093 */     int primitiveB1;
/* 094 */     {
/* 095 */
/* 096 */       boolean isNull4 = i.isNullAt(1);
/* 097 */       int value4 = isNull4 ? -1 : (i.getInt(1));
/* 098 */       boolean isNull3 = isNull4;
/* 099 */       int value3 = value4;
/* 100 */       if (isNull3) {
/* 101 */
/* 102 */         if (!false) {
/* 103 */           isNull3 = false;
/* 104 */           value3 = 0;
/* 105 */         }
/* 106 */       }
/* 107 */       isNullB1 = isNull3;
/* 108 */       primitiveB1 = value3;
/* 109 */     }
/* 110 */     if (isNullA1 && isNullB1) {
/* 111 */       // Nothing
/* 112 */     } else if (isNullA1) {
/* 113 */       return -1;
/* 114 */     } else if (isNullB1) {
/* 115 */       return 1;
/* 116 */     } else {
/* 117 */       int comp = (primitiveA1 > primitiveB1 ? 1 : primitiveA1 < primitiveB1 ? -1 : 0);
/* 118 */       if (comp != 0) {
/* 119 */         return comp;
/* 120 */       }
/* 121 */     }
/* 122 */
/* 123 */
/* 124 */     i = a;
/* 125 */     boolean isNullA2;
/* 126 */     int primitiveA2;
/* 127 */     {
/* 128 */
/* 129 */       boolean isNull7 = i.isNullAt(2);
/* 130 */       int value7 = isNull7 ? -1 : (i.getInt(2));
/* 131 */       boolean isNull6 = isNull7;
/* 132 */       int value6 = value7;
/* 133 */       if (isNull6) {
/* 134 */
/* 135 */         if (!false) {
/* 136 */           isNull6 = false;
/* 137 */           value6 = 0;
/* 138 */         }
/* 139 */       }
/* 140 */       isNullA2 = isNull6;
/* 141 */       primitiveA2 = value6;
/* 142 */     }
/* 143 */     i = b;
/* 144 */     boolean isNullB2;
/* 145 */     int primitiveB2;
/* 146 */     {
/* 147 */
/* 148 */       boolean isNull7 = i.isNullAt(2);
/* 149 */       int value7 = isNull7 ? -1 : (i.getInt(2));
/* 150 */       boolean isNull6 = isNull7;
/* 151 */       int value6 = value7;
/* 152 */       if (isNull6) {
/* 153 */
/* 154 */         if (!false) {
/* 155 */           isNull6 = false;
/* 156 */           value6 = 0;
/* 157 */         }
/* 158 */       }
/* 159 */       isNullB2 = isNull6;
/* 160 */       primitiveB2 = value6;
/* 161 */     }
/* 162 */     if (isNullA2 && isNullB2) {
/* 163 */       // Nothing
/* 164 */     } else if (isNullA2) {
/* 165 */       return -1;
/* 166 */     } else if (isNullB2) {
/* 167 */       return 1;
/* 168 */     } else {
/* 169 */       int comp = (primitiveA2 > primitiveB2 ? 1 : primitiveA2 < primitiveB2 ? -1 : 0);
/* 170 */       if (comp != 0) {
/* 171 */         return comp;
/* 172 */       }
/* 173 */     }
/* 174 */
/* 175 */     return 0;
/* 176 */   }
/* 177 */ }

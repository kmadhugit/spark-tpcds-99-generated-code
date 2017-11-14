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
/* 022 */     UTF8String primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull1 = i.isNullAt(0);
/* 026 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 027 */       boolean isNull = isNull1;
/* 028 */       UTF8String value = value1;
/* 029 */       if (isNull) {
/* 030 */
/* 031 */         Object obj = ((Expression) references[0]).eval(null);
/* 032 */         UTF8String value2 = (UTF8String) obj;
/* 033 */         if (!false) {
/* 034 */           isNull = false;
/* 035 */           value = value2;
/* 036 */         }
/* 037 */       }
/* 038 */       isNullA = isNull;
/* 039 */       primitiveA = value;
/* 040 */     }
/* 041 */     i = b;
/* 042 */     boolean isNullB;
/* 043 */     UTF8String primitiveB;
/* 044 */     {
/* 045 */
/* 046 */       boolean isNull1 = i.isNullAt(0);
/* 047 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 048 */       boolean isNull = isNull1;
/* 049 */       UTF8String value = value1;
/* 050 */       if (isNull) {
/* 051 */
/* 052 */         Object obj = ((Expression) references[0]).eval(null);
/* 053 */         UTF8String value2 = (UTF8String) obj;
/* 054 */         if (!false) {
/* 055 */           isNull = false;
/* 056 */           value = value2;
/* 057 */         }
/* 058 */       }
/* 059 */       isNullB = isNull;
/* 060 */       primitiveB = value;
/* 061 */     }
/* 062 */     if (isNullA && isNullB) {
/* 063 */       // Nothing
/* 064 */     } else if (isNullA) {
/* 065 */       return -1;
/* 066 */     } else if (isNullB) {
/* 067 */       return 1;
/* 068 */     } else {
/* 069 */       int comp = primitiveA.compare(primitiveB);
/* 070 */       if (comp != 0) {
/* 071 */         return comp;
/* 072 */       }
/* 073 */     }
/* 074 */
/* 075 */
/* 076 */     i = a;
/* 077 */     boolean isNullA1;
/* 078 */     UTF8String primitiveA1;
/* 079 */     {
/* 080 */
/* 081 */       boolean isNull4 = i.isNullAt(1);
/* 082 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 083 */       boolean isNull3 = isNull4;
/* 084 */       UTF8String value3 = value4;
/* 085 */       if (isNull3) {
/* 086 */
/* 087 */         Object obj1 = ((Expression) references[1]).eval(null);
/* 088 */         UTF8String value5 = (UTF8String) obj1;
/* 089 */         if (!false) {
/* 090 */           isNull3 = false;
/* 091 */           value3 = value5;
/* 092 */         }
/* 093 */       }
/* 094 */       isNullA1 = isNull3;
/* 095 */       primitiveA1 = value3;
/* 096 */     }
/* 097 */     i = b;
/* 098 */     boolean isNullB1;
/* 099 */     UTF8String primitiveB1;
/* 100 */     {
/* 101 */
/* 102 */       boolean isNull4 = i.isNullAt(1);
/* 103 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 104 */       boolean isNull3 = isNull4;
/* 105 */       UTF8String value3 = value4;
/* 106 */       if (isNull3) {
/* 107 */
/* 108 */         Object obj1 = ((Expression) references[1]).eval(null);
/* 109 */         UTF8String value5 = (UTF8String) obj1;
/* 110 */         if (!false) {
/* 111 */           isNull3 = false;
/* 112 */           value3 = value5;
/* 113 */         }
/* 114 */       }
/* 115 */       isNullB1 = isNull3;
/* 116 */       primitiveB1 = value3;
/* 117 */     }
/* 118 */     if (isNullA1 && isNullB1) {
/* 119 */       // Nothing
/* 120 */     } else if (isNullA1) {
/* 121 */       return -1;
/* 122 */     } else if (isNullB1) {
/* 123 */       return 1;
/* 124 */     } else {
/* 125 */       int comp = primitiveA1.compare(primitiveB1);
/* 126 */       if (comp != 0) {
/* 127 */         return comp;
/* 128 */       }
/* 129 */     }
/* 130 */
/* 131 */
/* 132 */     i = a;
/* 133 */     boolean isNullA2;
/* 134 */     UTF8String primitiveA2;
/* 135 */     {
/* 136 */
/* 137 */       boolean isNull7 = i.isNullAt(2);
/* 138 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(2));
/* 139 */       boolean isNull6 = isNull7;
/* 140 */       UTF8String value6 = value7;
/* 141 */       if (isNull6) {
/* 142 */
/* 143 */         Object obj2 = ((Expression) references[2]).eval(null);
/* 144 */         UTF8String value8 = (UTF8String) obj2;
/* 145 */         if (!false) {
/* 146 */           isNull6 = false;
/* 147 */           value6 = value8;
/* 148 */         }
/* 149 */       }
/* 150 */       isNullA2 = isNull6;
/* 151 */       primitiveA2 = value6;
/* 152 */     }
/* 153 */     i = b;
/* 154 */     boolean isNullB2;
/* 155 */     UTF8String primitiveB2;
/* 156 */     {
/* 157 */
/* 158 */       boolean isNull7 = i.isNullAt(2);
/* 159 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(2));
/* 160 */       boolean isNull6 = isNull7;
/* 161 */       UTF8String value6 = value7;
/* 162 */       if (isNull6) {
/* 163 */
/* 164 */         Object obj2 = ((Expression) references[2]).eval(null);
/* 165 */         UTF8String value8 = (UTF8String) obj2;
/* 166 */         if (!false) {
/* 167 */           isNull6 = false;
/* 168 */           value6 = value8;
/* 169 */         }
/* 170 */       }
/* 171 */       isNullB2 = isNull6;
/* 172 */       primitiveB2 = value6;
/* 173 */     }
/* 174 */     if (isNullA2 && isNullB2) {
/* 175 */       // Nothing
/* 176 */     } else if (isNullA2) {
/* 177 */       return -1;
/* 178 */     } else if (isNullB2) {
/* 179 */       return 1;
/* 180 */     } else {
/* 181 */       int comp = primitiveA2.compare(primitiveB2);
/* 182 */       if (comp != 0) {
/* 183 */         return comp;
/* 184 */       }
/* 185 */     }
/* 186 */
/* 187 */     return 0;
/* 188 */   }
/* 189 */ }

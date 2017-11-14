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
/* 022 */     double primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull = i.isNullAt(4);
/* 026 */       double value = isNull ? -1.0 : (i.getDouble(4));
/* 027 */       isNullA = isNull;
/* 028 */       primitiveA = value;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB;
/* 032 */     double primitiveB;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull = i.isNullAt(4);
/* 036 */       double value = isNull ? -1.0 : (i.getDouble(4));
/* 037 */       isNullB = isNull;
/* 038 */       primitiveB = value;
/* 039 */     }
/* 040 */     if (isNullA && isNullB) {
/* 041 */       // Nothing
/* 042 */     } else if (isNullA) {
/* 043 */       return 1;
/* 044 */     } else if (isNullB) {
/* 045 */       return -1;
/* 046 */     } else {
/* 047 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA, primitiveB);
/* 048 */       if (comp != 0) {
/* 049 */         return -comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */
/* 054 */     i = a;
/* 055 */     boolean isNullA1;
/* 056 */     double primitiveA1;
/* 057 */     {
/* 058 */
/* 059 */       boolean isNull1 = i.isNullAt(5);
/* 060 */       double value1 = isNull1 ? -1.0 : (i.getDouble(5));
/* 061 */       isNullA1 = isNull1;
/* 062 */       primitiveA1 = value1;
/* 063 */     }
/* 064 */     i = b;
/* 065 */     boolean isNullB1;
/* 066 */     double primitiveB1;
/* 067 */     {
/* 068 */
/* 069 */       boolean isNull1 = i.isNullAt(5);
/* 070 */       double value1 = isNull1 ? -1.0 : (i.getDouble(5));
/* 071 */       isNullB1 = isNull1;
/* 072 */       primitiveB1 = value1;
/* 073 */     }
/* 074 */     if (isNullA1 && isNullB1) {
/* 075 */       // Nothing
/* 076 */     } else if (isNullA1) {
/* 077 */       return 1;
/* 078 */     } else if (isNullB1) {
/* 079 */       return -1;
/* 080 */     } else {
/* 081 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA1, primitiveB1);
/* 082 */       if (comp != 0) {
/* 083 */         return -comp;
/* 084 */       }
/* 085 */     }
/* 086 */
/* 087 */
/* 088 */     i = a;
/* 089 */     boolean isNullA2;
/* 090 */     UTF8String primitiveA2;
/* 091 */     {
/* 092 */
/* 093 */       boolean isNull2 = i.isNullAt(1);
/* 094 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(1));
/* 095 */       isNullA2 = isNull2;
/* 096 */       primitiveA2 = value2;
/* 097 */     }
/* 098 */     i = b;
/* 099 */     boolean isNullB2;
/* 100 */     UTF8String primitiveB2;
/* 101 */     {
/* 102 */
/* 103 */       boolean isNull2 = i.isNullAt(1);
/* 104 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(1));
/* 105 */       isNullB2 = isNull2;
/* 106 */       primitiveB2 = value2;
/* 107 */     }
/* 108 */     if (isNullA2 && isNullB2) {
/* 109 */       // Nothing
/* 110 */     } else if (isNullA2) {
/* 111 */       return -1;
/* 112 */     } else if (isNullB2) {
/* 113 */       return 1;
/* 114 */     } else {
/* 115 */       int comp = primitiveA2.compare(primitiveB2);
/* 116 */       if (comp != 0) {
/* 117 */         return comp;
/* 118 */       }
/* 119 */     }
/* 120 */
/* 121 */
/* 122 */     i = a;
/* 123 */     boolean isNullA3;
/* 124 */     int primitiveA3;
/* 125 */     {
/* 126 */
/* 127 */       boolean isNull3 = i.isNullAt(0);
/* 128 */       int value3 = isNull3 ? -1 : (i.getInt(0));
/* 129 */       isNullA3 = isNull3;
/* 130 */       primitiveA3 = value3;
/* 131 */     }
/* 132 */     i = b;
/* 133 */     boolean isNullB3;
/* 134 */     int primitiveB3;
/* 135 */     {
/* 136 */
/* 137 */       boolean isNull3 = i.isNullAt(0);
/* 138 */       int value3 = isNull3 ? -1 : (i.getInt(0));
/* 139 */       isNullB3 = isNull3;
/* 140 */       primitiveB3 = value3;
/* 141 */     }
/* 142 */     if (isNullA3 && isNullB3) {
/* 143 */       // Nothing
/* 144 */     } else if (isNullA3) {
/* 145 */       return -1;
/* 146 */     } else if (isNullB3) {
/* 147 */       return 1;
/* 148 */     } else {
/* 149 */       int comp = (primitiveA3 > primitiveB3 ? 1 : primitiveA3 < primitiveB3 ? -1 : 0);
/* 150 */       if (comp != 0) {
/* 151 */         return comp;
/* 152 */       }
/* 153 */     }
/* 154 */
/* 155 */
/* 156 */     i = a;
/* 157 */     boolean isNullA4;
/* 158 */     int primitiveA4;
/* 159 */     {
/* 160 */
/* 161 */       boolean isNull4 = i.isNullAt(2);
/* 162 */       int value4 = isNull4 ? -1 : (i.getInt(2));
/* 163 */       isNullA4 = isNull4;
/* 164 */       primitiveA4 = value4;
/* 165 */     }
/* 166 */     i = b;
/* 167 */     boolean isNullB4;
/* 168 */     int primitiveB4;
/* 169 */     {
/* 170 */
/* 171 */       boolean isNull4 = i.isNullAt(2);
/* 172 */       int value4 = isNull4 ? -1 : (i.getInt(2));
/* 173 */       isNullB4 = isNull4;
/* 174 */       primitiveB4 = value4;
/* 175 */     }
/* 176 */     if (isNullA4 && isNullB4) {
/* 177 */       // Nothing
/* 178 */     } else if (isNullA4) {
/* 179 */       return -1;
/* 180 */     } else if (isNullB4) {
/* 181 */       return 1;
/* 182 */     } else {
/* 183 */       int comp = (primitiveA4 > primitiveB4 ? 1 : primitiveA4 < primitiveB4 ? -1 : 0);
/* 184 */       if (comp != 0) {
/* 185 */         return comp;
/* 186 */       }
/* 187 */     }
/* 188 */
/* 189 */
/* 190 */     i = a;
/* 191 */     boolean isNullA5;
/* 192 */     UTF8String primitiveA5;
/* 193 */     {
/* 194 */
/* 195 */       boolean isNull5 = i.isNullAt(3);
/* 196 */       UTF8String value5 = isNull5 ? null : (i.getUTF8String(3));
/* 197 */       isNullA5 = isNull5;
/* 198 */       primitiveA5 = value5;
/* 199 */     }
/* 200 */     i = b;
/* 201 */     boolean isNullB5;
/* 202 */     UTF8String primitiveB5;
/* 203 */     {
/* 204 */
/* 205 */       boolean isNull5 = i.isNullAt(3);
/* 206 */       UTF8String value5 = isNull5 ? null : (i.getUTF8String(3));
/* 207 */       isNullB5 = isNull5;
/* 208 */       primitiveB5 = value5;
/* 209 */     }
/* 210 */     if (isNullA5 && isNullB5) {
/* 211 */       // Nothing
/* 212 */     } else if (isNullA5) {
/* 213 */       return -1;
/* 214 */     } else if (isNullB5) {
/* 215 */       return 1;
/* 216 */     } else {
/* 217 */       int comp = primitiveA5.compare(primitiveB5);
/* 218 */       if (comp != 0) {
/* 219 */         return comp;
/* 220 */       }
/* 221 */     }
/* 222 */
/* 223 */     return 0;
/* 224 */   }
/* 225 */ }

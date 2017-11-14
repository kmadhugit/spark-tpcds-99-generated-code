/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificSafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificSafeProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private Object[] values;
/* 010 */   private org.apache.spark.sql.types.StructType schema;
/* 011 */
/* 012 */   public SpecificSafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     mutableRow = (InternalRow) references[references.length - 1];
/* 015 */
/* 016 */     this.schema = (org.apache.spark.sql.types.StructType) references[0];
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_4(InternalRow i) {
/* 026 */
/* 027 */     boolean isNull19 = i.isNullAt(10);
/* 028 */     UTF8String value19 = isNull19 ? null : (i.getUTF8String(10));
/* 029 */     boolean isNull18 = true;
/* 030 */     java.lang.String value18 = null;
/* 031 */     if (!isNull19) {
/* 032 */
/* 033 */       isNull18 = false;
/* 034 */       if (!isNull18) {
/* 035 */
/* 036 */         Object funcResult7 = null;
/* 037 */         funcResult7 = value19.toString();
/* 038 */         value18 = (java.lang.String) funcResult7;
/* 039 */
/* 040 */       }
/* 041 */     }
/* 042 */     if (isNull18) {
/* 043 */       values[10] = null;
/* 044 */     } else {
/* 045 */       values[10] = value18;
/* 046 */     }
/* 047 */
/* 048 */     boolean isNull21 = i.isNullAt(11);
/* 049 */     UTF8String value21 = isNull21 ? null : (i.getUTF8String(11));
/* 050 */     boolean isNull20 = true;
/* 051 */     java.lang.String value20 = null;
/* 052 */     if (!isNull21) {
/* 053 */
/* 054 */       isNull20 = false;
/* 055 */       if (!isNull20) {
/* 056 */
/* 057 */         Object funcResult8 = null;
/* 058 */         funcResult8 = value21.toString();
/* 059 */         value20 = (java.lang.String) funcResult8;
/* 060 */
/* 061 */       }
/* 062 */     }
/* 063 */     if (isNull20) {
/* 064 */       values[11] = null;
/* 065 */     } else {
/* 066 */       values[11] = value20;
/* 067 */     }
/* 068 */
/* 069 */   }
/* 070 */
/* 071 */
/* 072 */   private void apply_1(InternalRow i) {
/* 073 */
/* 074 */     boolean isNull6 = i.isNullAt(2);
/* 075 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(2));
/* 076 */     boolean isNull5 = true;
/* 077 */     java.lang.String value5 = null;
/* 078 */     if (!isNull6) {
/* 079 */
/* 080 */       isNull5 = false;
/* 081 */       if (!isNull5) {
/* 082 */
/* 083 */         Object funcResult2 = null;
/* 084 */         funcResult2 = value6.toString();
/* 085 */         value5 = (java.lang.String) funcResult2;
/* 086 */
/* 087 */       }
/* 088 */     }
/* 089 */     if (isNull5) {
/* 090 */       values[2] = null;
/* 091 */     } else {
/* 092 */       values[2] = value5;
/* 093 */     }
/* 094 */
/* 095 */     boolean isNull8 = i.isNullAt(3);
/* 096 */     UTF8String value8 = isNull8 ? null : (i.getUTF8String(3));
/* 097 */     boolean isNull7 = true;
/* 098 */     java.lang.String value7 = null;
/* 099 */     if (!isNull8) {
/* 100 */
/* 101 */       isNull7 = false;
/* 102 */       if (!isNull7) {
/* 103 */
/* 104 */         Object funcResult3 = null;
/* 105 */         funcResult3 = value8.toString();
/* 106 */         value7 = (java.lang.String) funcResult3;
/* 107 */
/* 108 */       }
/* 109 */     }
/* 110 */     if (isNull7) {
/* 111 */       values[3] = null;
/* 112 */     } else {
/* 113 */       values[3] = value7;
/* 114 */     }
/* 115 */
/* 116 */   }
/* 117 */
/* 118 */
/* 119 */   private void apply_3(InternalRow i) {
/* 120 */
/* 121 */     boolean isNull15 = i.isNullAt(8);
/* 122 */     UTF8String value15 = isNull15 ? null : (i.getUTF8String(8));
/* 123 */     boolean isNull14 = true;
/* 124 */     java.lang.String value14 = null;
/* 125 */     if (!isNull15) {
/* 126 */
/* 127 */       isNull14 = false;
/* 128 */       if (!isNull14) {
/* 129 */
/* 130 */         Object funcResult5 = null;
/* 131 */         funcResult5 = value15.toString();
/* 132 */         value14 = (java.lang.String) funcResult5;
/* 133 */
/* 134 */       }
/* 135 */     }
/* 136 */     if (isNull14) {
/* 137 */       values[8] = null;
/* 138 */     } else {
/* 139 */       values[8] = value14;
/* 140 */     }
/* 141 */
/* 142 */     boolean isNull17 = i.isNullAt(9);
/* 143 */     UTF8String value17 = isNull17 ? null : (i.getUTF8String(9));
/* 144 */     boolean isNull16 = true;
/* 145 */     java.lang.String value16 = null;
/* 146 */     if (!isNull17) {
/* 147 */
/* 148 */       isNull16 = false;
/* 149 */       if (!isNull16) {
/* 150 */
/* 151 */         Object funcResult6 = null;
/* 152 */         funcResult6 = value17.toString();
/* 153 */         value16 = (java.lang.String) funcResult6;
/* 154 */
/* 155 */       }
/* 156 */     }
/* 157 */     if (isNull16) {
/* 158 */       values[9] = null;
/* 159 */     } else {
/* 160 */       values[9] = value16;
/* 161 */     }
/* 162 */
/* 163 */   }
/* 164 */
/* 165 */
/* 166 */   private void apply_0(InternalRow i) {
/* 167 */
/* 168 */     boolean isNull2 = i.isNullAt(0);
/* 169 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 170 */     boolean isNull1 = true;
/* 171 */     java.lang.String value1 = null;
/* 172 */     if (!isNull2) {
/* 173 */
/* 174 */       isNull1 = false;
/* 175 */       if (!isNull1) {
/* 176 */
/* 177 */         Object funcResult = null;
/* 178 */         funcResult = value2.toString();
/* 179 */         value1 = (java.lang.String) funcResult;
/* 180 */
/* 181 */       }
/* 182 */     }
/* 183 */     if (isNull1) {
/* 184 */       values[0] = null;
/* 185 */     } else {
/* 186 */       values[0] = value1;
/* 187 */     }
/* 188 */
/* 189 */     boolean isNull4 = i.isNullAt(1);
/* 190 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 191 */     boolean isNull3 = true;
/* 192 */     java.lang.String value3 = null;
/* 193 */     if (!isNull4) {
/* 194 */
/* 195 */       isNull3 = false;
/* 196 */       if (!isNull3) {
/* 197 */
/* 198 */         Object funcResult1 = null;
/* 199 */         funcResult1 = value4.toString();
/* 200 */         value3 = (java.lang.String) funcResult1;
/* 201 */
/* 202 */       }
/* 203 */     }
/* 204 */     if (isNull3) {
/* 205 */       values[1] = null;
/* 206 */     } else {
/* 207 */       values[1] = value3;
/* 208 */     }
/* 209 */
/* 210 */   }
/* 211 */
/* 212 */
/* 213 */   private void apply_2(InternalRow i) {
/* 214 */
/* 215 */     boolean isNull10 = i.isNullAt(4);
/* 216 */     UTF8String value10 = isNull10 ? null : (i.getUTF8String(4));
/* 217 */     boolean isNull9 = true;
/* 218 */     java.lang.String value9 = null;
/* 219 */     if (!isNull10) {
/* 220 */
/* 221 */       isNull9 = false;
/* 222 */       if (!isNull9) {
/* 223 */
/* 224 */         Object funcResult4 = null;
/* 225 */         funcResult4 = value10.toString();
/* 226 */         value9 = (java.lang.String) funcResult4;
/* 227 */
/* 228 */       }
/* 229 */     }
/* 230 */     if (isNull9) {
/* 231 */       values[4] = null;
/* 232 */     } else {
/* 233 */       values[4] = value9;
/* 234 */     }
/* 235 */
/* 236 */     boolean isNull11 = i.isNullAt(5);
/* 237 */     int value11 = isNull11 ? -1 : (i.getInt(5));
/* 238 */     if (isNull11) {
/* 239 */       values[5] = null;
/* 240 */     } else {
/* 241 */       values[5] = value11;
/* 242 */     }
/* 243 */
/* 244 */     boolean isNull12 = i.isNullAt(6);
/* 245 */     int value12 = isNull12 ? -1 : (i.getInt(6));
/* 246 */     if (isNull12) {
/* 247 */       values[6] = null;
/* 248 */     } else {
/* 249 */       values[6] = value12;
/* 250 */     }
/* 251 */
/* 252 */     boolean isNull13 = i.isNullAt(7);
/* 253 */     int value13 = isNull13 ? -1 : (i.getInt(7));
/* 254 */     if (isNull13) {
/* 255 */       values[7] = null;
/* 256 */     } else {
/* 257 */       values[7] = value13;
/* 258 */     }
/* 259 */
/* 260 */   }
/* 261 */
/* 262 */
/* 263 */   private void apply_5(InternalRow i) {
/* 264 */
/* 265 */     boolean isNull22 = i.isNullAt(12);
/* 266 */     double value22 = isNull22 ? -1.0 : (i.getDouble(12));
/* 267 */     if (isNull22) {
/* 268 */       values[12] = null;
/* 269 */     } else {
/* 270 */       values[12] = value22;
/* 271 */     }
/* 272 */
/* 273 */   }
/* 274 */
/* 275 */
/* 276 */   public java.lang.Object apply(java.lang.Object _i) {
/* 277 */     InternalRow i = (InternalRow) _i;
/* 278 */
/* 279 */     values = new Object[13];
/* 280 */     apply_0(i);
/* 281 */     apply_1(i);
/* 282 */     apply_2(i);
/* 283 */     apply_3(i);
/* 284 */     apply_4(i);
/* 285 */     apply_5(i);
/* 286 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 287 */     if (false) {
/* 288 */       mutableRow.setNullAt(0);
/* 289 */     } else {
/* 290 */
/* 291 */       mutableRow.update(0, value);
/* 292 */     }
/* 293 */
/* 294 */     return mutableRow;
/* 295 */   }
/* 296 */ }

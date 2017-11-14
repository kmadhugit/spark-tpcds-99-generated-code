/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private int smj_value4;
/* 013 */   private int smj_value5;
/* 014 */   private java.util.ArrayList smj_matches;
/* 015 */   private int smj_value6;
/* 016 */   private int smj_value7;
/* 017 */   private int smj_value8;
/* 018 */   private boolean smj_isNull4;
/* 019 */   private int smj_value9;
/* 020 */   private boolean smj_isNull5;
/* 021 */   private long smj_value10;
/* 022 */   private boolean smj_isNull6;
/* 023 */   private double smj_value11;
/* 024 */   private boolean smj_isNull7;
/* 025 */   private double smj_value12;
/* 026 */   private boolean smj_isNull8;
/* 027 */   private long smj_value13;
/* 028 */   private boolean smj_isNull9;
/* 029 */   private double smj_value14;
/* 030 */   private boolean smj_isNull10;
/* 031 */   private double smj_value15;
/* 032 */   private boolean smj_isNull11;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 034 */   private UnsafeRow smj_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 037 */   private UnsafeRow project_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 040 */
/* 041 */   public GeneratedIterator(Object[] references) {
/* 042 */     this.references = references;
/* 043 */   }
/* 044 */
/* 045 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 046 */     partitionIndex = index;
/* 047 */     this.inputs = inputs;
/* 048 */     smj_leftInput = inputs[0];
/* 049 */     smj_rightInput = inputs[1];
/* 050 */
/* 051 */     smj_rightRow = null;
/* 052 */
/* 053 */     smj_matches = new java.util.ArrayList();
/* 054 */
/* 055 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 056 */     smj_result = new UnsafeRow(13);
/* 057 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 058 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 13);
/* 059 */     project_result = new UnsafeRow(12);
/* 060 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 061 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 12);
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */   private boolean findNextInnerJoinRows(
/* 066 */     scala.collection.Iterator leftIter,
/* 067 */     scala.collection.Iterator rightIter) {
/* 068 */     smj_leftRow = null;
/* 069 */     int comp = 0;
/* 070 */     while (smj_leftRow == null) {
/* 071 */       if (!leftIter.hasNext()) return false;
/* 072 */       smj_leftRow = (InternalRow) leftIter.next();
/* 073 */
/* 074 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 075 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 076 */
/* 077 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 078 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(1));
/* 079 */       if (smj_isNull || smj_isNull1) {
/* 080 */         smj_leftRow = null;
/* 081 */         continue;
/* 082 */       }
/* 083 */       if (!smj_matches.isEmpty()) {
/* 084 */         comp = 0;
/* 085 */         if (comp == 0) {
/* 086 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 087 */         }
/* 088 */         if (comp == 0) {
/* 089 */           comp = (smj_value1 > smj_value7 ? 1 : smj_value1 < smj_value7 ? -1 : 0);
/* 090 */         }
/* 091 */
/* 092 */         if (comp == 0) {
/* 093 */           return true;
/* 094 */         }
/* 095 */         smj_matches.clear();
/* 096 */       }
/* 097 */
/* 098 */       do {
/* 099 */         if (smj_rightRow == null) {
/* 100 */           if (!rightIter.hasNext()) {
/* 101 */             smj_value6 = smj_value;
/* 102 */             smj_value7 = smj_value1;
/* 103 */             return !smj_matches.isEmpty();
/* 104 */           }
/* 105 */           smj_rightRow = (InternalRow) rightIter.next();
/* 106 */
/* 107 */           boolean smj_isNull2 = smj_rightRow.isNullAt(0);
/* 108 */           int smj_value2 = smj_isNull2 ? -1 : (smj_rightRow.getInt(0));
/* 109 */
/* 110 */           boolean smj_isNull3 = smj_rightRow.isNullAt(1);
/* 111 */           int smj_value3 = smj_isNull3 ? -1 : (smj_rightRow.getInt(1));
/* 112 */           if (smj_isNull2 || smj_isNull3) {
/* 113 */             smj_rightRow = null;
/* 114 */             continue;
/* 115 */           }
/* 116 */           smj_value4 = smj_value2;
/* 117 */           smj_value5 = smj_value3;
/* 118 */         }
/* 119 */
/* 120 */         comp = 0;
/* 121 */         if (comp == 0) {
/* 122 */           comp = (smj_value > smj_value4 ? 1 : smj_value < smj_value4 ? -1 : 0);
/* 123 */         }
/* 124 */         if (comp == 0) {
/* 125 */           comp = (smj_value1 > smj_value5 ? 1 : smj_value1 < smj_value5 ? -1 : 0);
/* 126 */         }
/* 127 */
/* 128 */         if (comp > 0) {
/* 129 */           smj_rightRow = null;
/* 130 */         } else if (comp < 0) {
/* 131 */           if (!smj_matches.isEmpty()) {
/* 132 */             smj_value6 = smj_value;
/* 133 */             smj_value7 = smj_value1;
/* 134 */             return true;
/* 135 */           }
/* 136 */           smj_leftRow = null;
/* 137 */         } else {
/* 138 */           smj_matches.add(smj_rightRow.copy());
/* 139 */           smj_rightRow = null;;
/* 140 */         }
/* 141 */       } while (smj_leftRow != null);
/* 142 */     }
/* 143 */     return false; // unreachable
/* 144 */   }
/* 145 */
/* 146 */   protected void processNext() throws java.io.IOException {
/* 147 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 148 */       int smj_size = smj_matches.size();
/* 149 */       smj_isNull4 = smj_leftRow.isNullAt(0);
/* 150 */       smj_value8 = smj_isNull4 ? -1 : (smj_leftRow.getInt(0));
/* 151 */       smj_isNull5 = smj_leftRow.isNullAt(1);
/* 152 */       smj_value9 = smj_isNull5 ? -1 : (smj_leftRow.getInt(1));
/* 153 */       smj_isNull6 = smj_leftRow.isNullAt(2);
/* 154 */       smj_value10 = smj_isNull6 ? -1L : (smj_leftRow.getLong(2));
/* 155 */       smj_isNull7 = smj_leftRow.isNullAt(3);
/* 156 */       smj_value11 = smj_isNull7 ? -1.0 : (smj_leftRow.getDouble(3));
/* 157 */       smj_isNull8 = smj_leftRow.isNullAt(4);
/* 158 */       smj_value12 = smj_isNull8 ? -1.0 : (smj_leftRow.getDouble(4));
/* 159 */       smj_isNull9 = smj_leftRow.isNullAt(5);
/* 160 */       smj_value13 = smj_isNull9 ? -1L : (smj_leftRow.getLong(5));
/* 161 */       smj_isNull10 = smj_leftRow.isNullAt(6);
/* 162 */       smj_value14 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(6));
/* 163 */       smj_isNull11 = smj_leftRow.isNullAt(7);
/* 164 */       smj_value15 = smj_isNull11 ? -1.0 : (smj_leftRow.getDouble(7));
/* 165 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 166 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 167 */
/* 168 */         smj_numOutputRows.add(1);
/* 169 */
/* 170 */         boolean smj_isNull14 = smj_rightRow1.isNullAt(2);
/* 171 */         long smj_value18 = smj_isNull14 ? -1L : (smj_rightRow1.getLong(2));
/* 172 */
/* 173 */         boolean project_isNull6 = true;
/* 174 */         long project_value6 = -1L;
/* 175 */
/* 176 */         if (!smj_isNull9) {
/* 177 */           if (!smj_isNull14) {
/* 178 */             project_isNull6 = false; // resultCode could change nullability.
/* 179 */             project_value6 = smj_value13 + smj_value18;
/* 180 */
/* 181 */           }
/* 182 */
/* 183 */         }
/* 184 */         boolean project_isNull5 = project_isNull6;
/* 185 */         long project_value5 = project_value6;
/* 186 */         if (project_isNull5) {
/* 187 */           if (!false) {
/* 188 */             project_isNull5 = false;
/* 189 */             project_value5 = 1L;
/* 190 */           }
/* 191 */         }
/* 192 */         boolean project_isNull4 = project_isNull5;
/* 193 */         double project_value4 = -1.0;
/* 194 */         if (!project_isNull5) {
/* 195 */           project_value4 = (double) project_value5;
/* 196 */         }
/* 197 */         boolean project_isNull1 = false;
/* 198 */         double project_value1 = -1.0;
/* 199 */         if (project_isNull4 || project_value4 == 0) {
/* 200 */           project_isNull1 = true;
/* 201 */         } else {
/* 202 */           boolean project_isNull2 = smj_isNull6;
/* 203 */           double project_value2 = -1.0;
/* 204 */           if (!smj_isNull6) {
/* 205 */             project_value2 = (double) smj_value10;
/* 206 */           }
/* 207 */           if (project_isNull2) {
/* 208 */             project_isNull1 = true;
/* 209 */           } else {
/* 210 */             project_value1 = (double)(project_value2 / project_value4);
/* 211 */           }
/* 212 */         }
/* 213 */         boolean project_isNull = project_isNull1;
/* 214 */         double project_value = -1.0;
/* 215 */         if (!project_isNull) {
/* 216 */           if (Double.isNaN(project_value1) || Double.isInfinite(project_value1)) {
/* 217 */             project_value = project_value1;
/* 218 */           } else {
/* 219 */             project_value = java.math.BigDecimal.valueOf(project_value1).
/* 220 */             setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
/* 221 */           }
/* 222 */         }
/* 223 */         boolean project_isNull13 = false;
/* 224 */
/* 225 */         boolean project_isNull14 = smj_isNull9;
/* 226 */         long project_value14 = smj_value13;
/* 227 */         if (project_isNull14) {
/* 228 */           if (!false) {
/* 229 */             project_isNull14 = false;
/* 230 */             project_value14 = 0L;
/* 231 */           }
/* 232 */         }
/* 233 */
/* 234 */         boolean project_isNull17 = smj_isNull14;
/* 235 */         long project_value17 = smj_value18;
/* 236 */         if (project_isNull17) {
/* 237 */           if (!false) {
/* 238 */             project_isNull17 = false;
/* 239 */             project_value17 = 0L;
/* 240 */           }
/* 241 */         }
/* 242 */         long project_value13 = -1L;
/* 243 */         project_value13 = project_value14 + project_value17;
/* 244 */         boolean project_isNull20 = false;
/* 245 */
/* 246 */         boolean project_isNull21 = smj_isNull10;
/* 247 */         double project_value21 = smj_value14;
/* 248 */         if (project_isNull21) {
/* 249 */           if (!false) {
/* 250 */             project_isNull21 = false;
/* 251 */             project_value21 = 0.0D;
/* 252 */           }
/* 253 */         }
/* 254 */
/* 255 */         boolean smj_isNull15 = smj_rightRow1.isNullAt(3);
/* 256 */         double smj_value19 = smj_isNull15 ? -1.0 : (smj_rightRow1.getDouble(3));
/* 257 */         boolean project_isNull24 = smj_isNull15;
/* 258 */         double project_value24 = smj_value19;
/* 259 */         if (project_isNull24) {
/* 260 */           if (!false) {
/* 261 */             project_isNull24 = false;
/* 262 */             project_value24 = 0.0D;
/* 263 */           }
/* 264 */         }
/* 265 */         double project_value20 = -1.0;
/* 266 */         project_value20 = project_value21 + project_value24;
/* 267 */         boolean project_isNull27 = false;
/* 268 */
/* 269 */         boolean project_isNull28 = smj_isNull11;
/* 270 */         double project_value28 = smj_value15;
/* 271 */         if (project_isNull28) {
/* 272 */           if (!false) {
/* 273 */             project_isNull28 = false;
/* 274 */             project_value28 = 0.0D;
/* 275 */           }
/* 276 */         }
/* 277 */
/* 278 */         boolean smj_isNull16 = smj_rightRow1.isNullAt(4);
/* 279 */         double smj_value20 = smj_isNull16 ? -1.0 : (smj_rightRow1.getDouble(4));
/* 280 */         boolean project_isNull31 = smj_isNull16;
/* 281 */         double project_value31 = smj_value20;
/* 282 */         if (project_isNull31) {
/* 283 */           if (!false) {
/* 284 */             project_isNull31 = false;
/* 285 */             project_value31 = 0.0D;
/* 286 */           }
/* 287 */         }
/* 288 */         double project_value27 = -1.0;
/* 289 */         project_value27 = project_value28 + project_value31;
/* 290 */         project_rowWriter.zeroOutNullBytes();
/* 291 */
/* 292 */         if (project_isNull) {
/* 293 */           project_rowWriter.setNullAt(0);
/* 294 */         } else {
/* 295 */           project_rowWriter.write(0, project_value);
/* 296 */         }
/* 297 */
/* 298 */         if (smj_isNull6) {
/* 299 */           project_rowWriter.setNullAt(1);
/* 300 */         } else {
/* 301 */           project_rowWriter.write(1, smj_value10);
/* 302 */         }
/* 303 */
/* 304 */         if (smj_isNull7) {
/* 305 */           project_rowWriter.setNullAt(2);
/* 306 */         } else {
/* 307 */           project_rowWriter.write(2, smj_value11);
/* 308 */         }
/* 309 */
/* 310 */         if (smj_isNull8) {
/* 311 */           project_rowWriter.setNullAt(3);
/* 312 */         } else {
/* 313 */           project_rowWriter.write(3, smj_value12);
/* 314 */         }
/* 315 */
/* 316 */         project_rowWriter.write(4, project_value13);
/* 317 */
/* 318 */         project_rowWriter.write(5, project_value20);
/* 319 */
/* 320 */         project_rowWriter.write(6, project_value27);
/* 321 */
/* 322 */         if (smj_isNull14) {
/* 323 */           project_rowWriter.setNullAt(7);
/* 324 */         } else {
/* 325 */           project_rowWriter.write(7, smj_value18);
/* 326 */         }
/* 327 */
/* 328 */         if (smj_isNull8) {
/* 329 */           project_rowWriter.setNullAt(8);
/* 330 */         } else {
/* 331 */           project_rowWriter.write(8, smj_value12);
/* 332 */         }
/* 333 */
/* 334 */         if (smj_isNull7) {
/* 335 */           project_rowWriter.setNullAt(9);
/* 336 */         } else {
/* 337 */           project_rowWriter.write(9, smj_value11);
/* 338 */         }
/* 339 */
/* 340 */         if (smj_isNull6) {
/* 341 */           project_rowWriter.setNullAt(10);
/* 342 */         } else {
/* 343 */           project_rowWriter.write(10, smj_value10);
/* 344 */         }
/* 345 */
/* 346 */         if (smj_isNull9) {
/* 347 */           project_rowWriter.setNullAt(11);
/* 348 */         } else {
/* 349 */           project_rowWriter.write(11, smj_value13);
/* 350 */         }
/* 351 */         append(project_result.copy());
/* 352 */
/* 353 */       }
/* 354 */       if (shouldStop()) return;
/* 355 */     }
/* 356 */   }
/* 357 */ }

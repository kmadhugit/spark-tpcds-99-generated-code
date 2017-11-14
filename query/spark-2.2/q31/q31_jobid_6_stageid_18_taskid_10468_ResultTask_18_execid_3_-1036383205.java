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
/* 012 */   private UTF8String smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private UTF8String smj_value3;
/* 015 */   private UTF8String smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private int smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private double smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private double smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private double smj_value8;
/* 024 */   private boolean smj_isNull6;
/* 025 */   private UTF8String smj_value9;
/* 026 */   private boolean smj_isNull7;
/* 027 */   private double smj_value10;
/* 028 */   private boolean smj_isNull8;
/* 029 */   private double smj_value11;
/* 030 */   private boolean smj_isNull9;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 032 */   private UnsafeRow smj_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */
/* 039 */   public GeneratedIterator(Object[] references) {
/* 040 */     this.references = references;
/* 041 */   }
/* 042 */
/* 043 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 044 */     partitionIndex = index;
/* 045 */     this.inputs = inputs;
/* 046 */     smj_leftInput = inputs[0];
/* 047 */     smj_rightInput = inputs[1];
/* 048 */
/* 049 */     smj_rightRow = null;
/* 050 */
/* 051 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 052 */
/* 053 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 054 */     smj_result = new UnsafeRow(10);
/* 055 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 056 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 10);
/* 057 */     project_result = new UnsafeRow(6);
/* 058 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 059 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 060 */
/* 061 */   }
/* 062 */
/* 063 */   private boolean findNextInnerJoinRows(
/* 064 */     scala.collection.Iterator leftIter,
/* 065 */     scala.collection.Iterator rightIter) {
/* 066 */     smj_leftRow = null;
/* 067 */     int comp = 0;
/* 068 */     while (smj_leftRow == null) {
/* 069 */       if (!leftIter.hasNext()) return false;
/* 070 */       smj_leftRow = (InternalRow) leftIter.next();
/* 071 */
/* 072 */       boolean smj_isNull = smj_leftRow.isNullAt(5);
/* 073 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(5));
/* 074 */       if (smj_isNull) {
/* 075 */         smj_leftRow = null;
/* 076 */         continue;
/* 077 */       }
/* 078 */       if (!smj_matches.isEmpty()) {
/* 079 */         comp = 0;
/* 080 */         if (comp == 0) {
/* 081 */           comp = smj_value.compare(smj_value3);
/* 082 */         }
/* 083 */
/* 084 */         if (comp == 0) {
/* 085 */           return true;
/* 086 */         }
/* 087 */         smj_matches.clear();
/* 088 */       }
/* 089 */
/* 090 */       do {
/* 091 */         if (smj_rightRow == null) {
/* 092 */           if (!rightIter.hasNext()) {
/* 093 */             smj_value3 = smj_value.clone();
/* 094 */             return !smj_matches.isEmpty();
/* 095 */           }
/* 096 */           smj_rightRow = (InternalRow) rightIter.next();
/* 097 */
/* 098 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 099 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 100 */           if (smj_isNull1) {
/* 101 */             smj_rightRow = null;
/* 102 */             continue;
/* 103 */           }
/* 104 */           smj_value2 = smj_value1.clone();
/* 105 */         }
/* 106 */
/* 107 */         comp = 0;
/* 108 */         if (comp == 0) {
/* 109 */           comp = smj_value.compare(smj_value2);
/* 110 */         }
/* 111 */
/* 112 */         if (comp > 0) {
/* 113 */           smj_rightRow = null;
/* 114 */         } else if (comp < 0) {
/* 115 */           if (!smj_matches.isEmpty()) {
/* 116 */             smj_value3 = smj_value.clone();
/* 117 */             return true;
/* 118 */           }
/* 119 */           smj_leftRow = null;
/* 120 */         } else {
/* 121 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 122 */           smj_rightRow = null;;
/* 123 */         }
/* 124 */       } while (smj_leftRow != null);
/* 125 */     }
/* 126 */     return false; // unreachable
/* 127 */   }
/* 128 */
/* 129 */   protected void processNext() throws java.io.IOException {
/* 130 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 131 */       boolean smj_loaded = false;
/* 132 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 133 */       smj_value7 = smj_isNull5 ? -1.0 : (smj_leftRow.getDouble(3));
/* 134 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 135 */       smj_value8 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(4));
/* 136 */       smj_isNull9 = smj_leftRow.isNullAt(7);
/* 137 */       smj_value11 = smj_isNull9 ? -1.0 : (smj_leftRow.getDouble(7));
/* 138 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 139 */       while (smj_iterator.hasNext()) {
/* 140 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 141 */         boolean smj_isNull11 = smj_rightRow1.isNullAt(1);
/* 142 */         double smj_value13 = smj_isNull11 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 143 */
/* 144 */         boolean smj_isNull12 = true;
/* 145 */         boolean smj_value14 = false;
/* 146 */
/* 147 */         boolean smj_isNull13 = true;
/* 148 */         double smj_value15 = -1.0;
/* 149 */
/* 150 */         boolean smj_isNull14 = true;
/* 151 */         boolean smj_value16 = false;
/* 152 */
/* 153 */         if (!smj_isNull9) {
/* 154 */           smj_isNull14 = false; // resultCode could change nullability.
/* 155 */           smj_value16 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value11, 0.0D) > 0;
/* 156 */
/* 157 */         }
/* 158 */         if (!smj_isNull14 && smj_value16) {
/* 159 */           boolean smj_isNull17 = false;
/* 160 */           double smj_value19 = -1.0;
/* 161 */           if (smj_isNull9 || smj_value11 == 0) {
/* 162 */             smj_isNull17 = true;
/* 163 */           } else {
/* 164 */             if (smj_isNull11) {
/* 165 */               smj_isNull17 = true;
/* 166 */             } else {
/* 167 */               smj_value19 = (double)(smj_value13 / smj_value11);
/* 168 */             }
/* 169 */           }
/* 170 */           smj_isNull13 = smj_isNull17;
/* 171 */           smj_value15 = smj_value19;
/* 172 */         }
/* 173 */
/* 174 */         else {
/* 175 */           final double smj_value22 = -1.0;
/* 176 */           smj_isNull13 = true;
/* 177 */           smj_value15 = smj_value22;
/* 178 */         }
/* 179 */         if (!smj_isNull13) {
/* 180 */           boolean smj_isNull21 = true;
/* 181 */           double smj_value23 = -1.0;
/* 182 */
/* 183 */           boolean smj_isNull22 = true;
/* 184 */           boolean smj_value24 = false;
/* 185 */
/* 186 */           if (!smj_isNull5) {
/* 187 */             smj_isNull22 = false; // resultCode could change nullability.
/* 188 */             smj_value24 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value7, 0.0D) > 0;
/* 189 */
/* 190 */           }
/* 191 */           if (!smj_isNull22 && smj_value24) {
/* 192 */             boolean smj_isNull25 = false;
/* 193 */             double smj_value27 = -1.0;
/* 194 */             if (smj_isNull5 || smj_value7 == 0) {
/* 195 */               smj_isNull25 = true;
/* 196 */             } else {
/* 197 */               if (smj_isNull6) {
/* 198 */                 smj_isNull25 = true;
/* 199 */               } else {
/* 200 */                 smj_value27 = (double)(smj_value8 / smj_value7);
/* 201 */               }
/* 202 */             }
/* 203 */             smj_isNull21 = smj_isNull25;
/* 204 */             smj_value23 = smj_value27;
/* 205 */           }
/* 206 */
/* 207 */           else {
/* 208 */             final double smj_value30 = -1.0;
/* 209 */             smj_isNull21 = true;
/* 210 */             smj_value23 = smj_value30;
/* 211 */           }
/* 212 */           if (!smj_isNull21) {
/* 213 */             smj_isNull12 = false; // resultCode could change nullability.
/* 214 */             smj_value14 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value15, smj_value23) > 0;
/* 215 */
/* 216 */           }
/* 217 */
/* 218 */         }
/* 219 */         if (smj_isNull12 || !smj_value14) continue;
/* 220 */         if (!smj_loaded) {
/* 221 */           smj_loaded = true;
/* 222 */           smj_isNull2 = smj_leftRow.isNullAt(0);
/* 223 */           smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 224 */           smj_isNull3 = smj_leftRow.isNullAt(1);
/* 225 */           smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 226 */           smj_isNull4 = smj_leftRow.isNullAt(2);
/* 227 */           smj_value6 = smj_isNull4 ? -1.0 : (smj_leftRow.getDouble(2));
/* 228 */           smj_isNull7 = smj_leftRow.isNullAt(5);
/* 229 */           smj_value9 = smj_isNull7 ? null : (smj_leftRow.getUTF8String(5));
/* 230 */           smj_isNull8 = smj_leftRow.isNullAt(6);
/* 231 */           smj_value10 = smj_isNull8 ? -1.0 : (smj_leftRow.getDouble(6));
/* 232 */         }
/* 233 */         boolean smj_isNull10 = smj_rightRow1.isNullAt(0);
/* 234 */         UTF8String smj_value12 = smj_isNull10 ? null : (smj_rightRow1.getUTF8String(0));
/* 235 */         smj_numOutputRows.add(1);
/* 236 */
/* 237 */         boolean project_isNull2 = false;
/* 238 */         double project_value2 = -1.0;
/* 239 */         if (smj_isNull8 || smj_value10 == 0) {
/* 240 */           project_isNull2 = true;
/* 241 */         } else {
/* 242 */           if (smj_isNull9) {
/* 243 */             project_isNull2 = true;
/* 244 */           } else {
/* 245 */             project_value2 = (double)(smj_value11 / smj_value10);
/* 246 */           }
/* 247 */         }
/* 248 */         boolean project_isNull5 = false;
/* 249 */         double project_value5 = -1.0;
/* 250 */         if (smj_isNull4 || smj_value6 == 0) {
/* 251 */           project_isNull5 = true;
/* 252 */         } else {
/* 253 */           if (smj_isNull5) {
/* 254 */             project_isNull5 = true;
/* 255 */           } else {
/* 256 */             project_value5 = (double)(smj_value7 / smj_value6);
/* 257 */           }
/* 258 */         }
/* 259 */         boolean project_isNull8 = false;
/* 260 */         double project_value8 = -1.0;
/* 261 */         if (smj_isNull9 || smj_value11 == 0) {
/* 262 */           project_isNull8 = true;
/* 263 */         } else {
/* 264 */           if (smj_isNull11) {
/* 265 */             project_isNull8 = true;
/* 266 */           } else {
/* 267 */             project_value8 = (double)(smj_value13 / smj_value11);
/* 268 */           }
/* 269 */         }
/* 270 */         boolean project_isNull11 = false;
/* 271 */         double project_value11 = -1.0;
/* 272 */         if (smj_isNull5 || smj_value7 == 0) {
/* 273 */           project_isNull11 = true;
/* 274 */         } else {
/* 275 */           if (smj_isNull6) {
/* 276 */             project_isNull11 = true;
/* 277 */           } else {
/* 278 */             project_value11 = (double)(smj_value8 / smj_value7);
/* 279 */           }
/* 280 */         }
/* 281 */         project_holder.reset();
/* 282 */
/* 283 */         project_rowWriter.zeroOutNullBytes();
/* 284 */
/* 285 */         if (smj_isNull2) {
/* 286 */           project_rowWriter.setNullAt(0);
/* 287 */         } else {
/* 288 */           project_rowWriter.write(0, smj_value4);
/* 289 */         }
/* 290 */
/* 291 */         if (smj_isNull3) {
/* 292 */           project_rowWriter.setNullAt(1);
/* 293 */         } else {
/* 294 */           project_rowWriter.write(1, smj_value5);
/* 295 */         }
/* 296 */
/* 297 */         if (project_isNull2) {
/* 298 */           project_rowWriter.setNullAt(2);
/* 299 */         } else {
/* 300 */           project_rowWriter.write(2, project_value2);
/* 301 */         }
/* 302 */
/* 303 */         if (project_isNull5) {
/* 304 */           project_rowWriter.setNullAt(3);
/* 305 */         } else {
/* 306 */           project_rowWriter.write(3, project_value5);
/* 307 */         }
/* 308 */
/* 309 */         if (project_isNull8) {
/* 310 */           project_rowWriter.setNullAt(4);
/* 311 */         } else {
/* 312 */           project_rowWriter.write(4, project_value8);
/* 313 */         }
/* 314 */
/* 315 */         if (project_isNull11) {
/* 316 */           project_rowWriter.setNullAt(5);
/* 317 */         } else {
/* 318 */           project_rowWriter.write(5, project_value11);
/* 319 */         }
/* 320 */         project_result.setTotalSize(project_holder.totalSize());
/* 321 */         append(project_result.copy());
/* 322 */
/* 323 */       }
/* 324 */       if (shouldStop()) return;
/* 325 */     }
/* 326 */   }
/* 327 */ }

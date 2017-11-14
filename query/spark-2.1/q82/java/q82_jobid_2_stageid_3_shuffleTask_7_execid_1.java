/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 011 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 012 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 015 */   private scala.collection.Iterator smj_leftInput;
/* 016 */   private scala.collection.Iterator smj_rightInput;
/* 017 */   private InternalRow smj_leftRow;
/* 018 */   private InternalRow smj_rightRow;
/* 019 */   private int smj_value2;
/* 020 */   private java.util.ArrayList smj_matches;
/* 021 */   private int smj_value3;
/* 022 */   private int smj_value4;
/* 023 */   private boolean smj_isNull2;
/* 024 */   private UTF8String smj_value5;
/* 025 */   private boolean smj_isNull3;
/* 026 */   private UTF8String smj_value6;
/* 027 */   private boolean smj_isNull4;
/* 028 */   private double smj_value7;
/* 029 */   private boolean smj_isNull5;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 031 */   private UnsafeRow smj_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 034 */   private UnsafeRow project_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 037 */   private UnsafeRow agg_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 040 */   private int agg_value6;
/* 041 */   private UnsafeRow agg_result1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 044 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 046 */
/* 047 */   public GeneratedIterator(Object[] references) {
/* 048 */     this.references = references;
/* 049 */   }
/* 050 */
/* 051 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 052 */     partitionIndex = index;
/* 053 */     this.inputs = inputs;
/* 054 */     wholestagecodegen_init_0();
/* 055 */     wholestagecodegen_init_1();
/* 056 */
/* 057 */   }
/* 058 */
/* 059 */   private void wholestagecodegen_init_0() {
/* 060 */     agg_initAgg = false;
/* 061 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 062 */
/* 063 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 064 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 065 */     smj_leftInput = inputs[0];
/* 066 */     smj_rightInput = inputs[1];
/* 067 */
/* 068 */     smj_rightRow = null;
/* 069 */
/* 070 */     smj_matches = new java.util.ArrayList();
/* 071 */
/* 072 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 073 */     smj_result = new UnsafeRow(5);
/* 074 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 075 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 076 */     project_result = new UnsafeRow(3);
/* 077 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 078 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 079 */     agg_result = new UnsafeRow(3);
/* 080 */
/* 081 */   }
/* 082 */
/* 083 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 084 */     agg_hashMap = agg_plan.createHashMap();
/* 085 */
/* 086 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 087 */       int smj_size = smj_matches.size();
/* 088 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 089 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 090 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 091 */       smj_value5 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(1));
/* 092 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 093 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 094 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 095 */       smj_value7 = smj_isNull5 ? -1.0 : (smj_leftRow.getDouble(3));
/* 096 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 097 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 098 */
/* 099 */         smj_numOutputRows.add(1);
/* 100 */
/* 101 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 102 */
/* 103 */         UnsafeRow agg_fastAggBuffer = null;
/* 104 */
/* 105 */         if (agg_fastAggBuffer == null) {
/* 106 */           // generate grouping key
/* 107 */           agg_holder.reset();
/* 108 */
/* 109 */           agg_rowWriter.zeroOutNullBytes();
/* 110 */
/* 111 */           if (smj_isNull3) {
/* 112 */             agg_rowWriter.setNullAt(0);
/* 113 */           } else {
/* 114 */             agg_rowWriter.write(0, smj_value5);
/* 115 */           }
/* 116 */
/* 117 */           if (smj_isNull4) {
/* 118 */             agg_rowWriter.setNullAt(1);
/* 119 */           } else {
/* 120 */             agg_rowWriter.write(1, smj_value6);
/* 121 */           }
/* 122 */
/* 123 */           if (smj_isNull5) {
/* 124 */             agg_rowWriter.setNullAt(2);
/* 125 */           } else {
/* 126 */             agg_rowWriter.write(2, smj_value7);
/* 127 */           }
/* 128 */           agg_result.setTotalSize(agg_holder.totalSize());
/* 129 */           agg_value6 = 42;
/* 130 */
/* 131 */           if (!smj_isNull3) {
/* 132 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value5.getBaseObject(), smj_value5.getBaseOffset(), smj_value5.numBytes(), agg_value6);
/* 133 */           }
/* 134 */
/* 135 */           if (!smj_isNull4) {
/* 136 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value6.getBaseObject(), smj_value6.getBaseOffset(), smj_value6.numBytes(), agg_value6);
/* 137 */           }
/* 138 */
/* 139 */           if (!smj_isNull5) {
/* 140 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(smj_value7), agg_value6);
/* 141 */           }
/* 142 */           if (true) {
/* 143 */             // try to get the buffer from hash map
/* 144 */             agg_unsafeRowAggBuffer =
/* 145 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 146 */           }
/* 147 */           if (agg_unsafeRowAggBuffer == null) {
/* 148 */             if (agg_sorter == null) {
/* 149 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 150 */             } else {
/* 151 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 152 */             }
/* 153 */
/* 154 */             // the hash map had be spilled, it should have enough memory now,
/* 155 */             // try  to allocate buffer again.
/* 156 */             agg_unsafeRowAggBuffer =
/* 157 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 158 */             if (agg_unsafeRowAggBuffer == null) {
/* 159 */               // failed to allocate the first page
/* 160 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 161 */             }
/* 162 */           }
/* 163 */         }
/* 164 */
/* 165 */         if (agg_fastAggBuffer != null) {
/* 166 */           // update fast row
/* 167 */
/* 168 */         } else {
/* 169 */           // update unsafe row
/* 170 */
/* 171 */           // common sub-expressions
/* 172 */
/* 173 */           // evaluate aggregate function
/* 174 */
/* 175 */           // update unsafe row buffer
/* 176 */
/* 177 */         }
/* 178 */
/* 179 */       }
/* 180 */       if (shouldStop()) return;
/* 181 */     }
/* 182 */
/* 183 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 184 */   }
/* 185 */
/* 186 */   private boolean findNextInnerJoinRows(
/* 187 */     scala.collection.Iterator leftIter,
/* 188 */     scala.collection.Iterator rightIter) {
/* 189 */     smj_leftRow = null;
/* 190 */     int comp = 0;
/* 191 */     while (smj_leftRow == null) {
/* 192 */       if (!leftIter.hasNext()) return false;
/* 193 */       smj_leftRow = (InternalRow) leftIter.next();
/* 194 */
/* 195 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 196 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 197 */       if (smj_isNull) {
/* 198 */         smj_leftRow = null;
/* 199 */         continue;
/* 200 */       }
/* 201 */       if (!smj_matches.isEmpty()) {
/* 202 */         comp = 0;
/* 203 */         if (comp == 0) {
/* 204 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 205 */         }
/* 206 */
/* 207 */         if (comp == 0) {
/* 208 */           return true;
/* 209 */         }
/* 210 */         smj_matches.clear();
/* 211 */       }
/* 212 */
/* 213 */       do {
/* 214 */         if (smj_rightRow == null) {
/* 215 */           if (!rightIter.hasNext()) {
/* 216 */             smj_value3 = smj_value;
/* 217 */             return !smj_matches.isEmpty();
/* 218 */           }
/* 219 */           smj_rightRow = (InternalRow) rightIter.next();
/* 220 */
/* 221 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 222 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 223 */           if (smj_isNull1) {
/* 224 */             smj_rightRow = null;
/* 225 */             continue;
/* 226 */           }
/* 227 */           smj_value2 = smj_value1;
/* 228 */         }
/* 229 */
/* 230 */         comp = 0;
/* 231 */         if (comp == 0) {
/* 232 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 233 */         }
/* 234 */
/* 235 */         if (comp > 0) {
/* 236 */           smj_rightRow = null;
/* 237 */         } else if (comp < 0) {
/* 238 */           if (!smj_matches.isEmpty()) {
/* 239 */             smj_value3 = smj_value;
/* 240 */             return true;
/* 241 */           }
/* 242 */           smj_leftRow = null;
/* 243 */         } else {
/* 244 */           smj_matches.add(smj_rightRow.copy());
/* 245 */           smj_rightRow = null;;
/* 246 */         }
/* 247 */       } while (smj_leftRow != null);
/* 248 */     }
/* 249 */     return false; // unreachable
/* 250 */   }
/* 251 */
/* 252 */   private void wholestagecodegen_init_1() {
/* 253 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 254 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 255 */
/* 256 */     agg_result1 = new UnsafeRow(3);
/* 257 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 258 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 259 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 260 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 261 */
/* 262 */   }
/* 263 */
/* 264 */   protected void processNext() throws java.io.IOException {
/* 265 */     if (!agg_initAgg) {
/* 266 */       agg_initAgg = true;
/* 267 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 268 */       agg_doAggregateWithKeys();
/* 269 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 270 */     }
/* 271 */
/* 272 */     // output the result
/* 273 */
/* 274 */     while (agg_mapIter.next()) {
/* 275 */       wholestagecodegen_numOutputRows.add(1);
/* 276 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 277 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 278 */
/* 279 */       boolean agg_isNull10 = agg_aggKey.isNullAt(0);
/* 280 */       UTF8String agg_value10 = agg_isNull10 ? null : (agg_aggKey.getUTF8String(0));
/* 281 */       boolean agg_isNull11 = agg_aggKey.isNullAt(1);
/* 282 */       UTF8String agg_value11 = agg_isNull11 ? null : (agg_aggKey.getUTF8String(1));
/* 283 */       boolean agg_isNull12 = agg_aggKey.isNullAt(2);
/* 284 */       double agg_value12 = agg_isNull12 ? -1.0 : (agg_aggKey.getDouble(2));
/* 285 */       agg_holder1.reset();
/* 286 */
/* 287 */       agg_rowWriter1.zeroOutNullBytes();
/* 288 */
/* 289 */       if (agg_isNull10) {
/* 290 */         agg_rowWriter1.setNullAt(0);
/* 291 */       } else {
/* 292 */         agg_rowWriter1.write(0, agg_value10);
/* 293 */       }
/* 294 */
/* 295 */       if (agg_isNull11) {
/* 296 */         agg_rowWriter1.setNullAt(1);
/* 297 */       } else {
/* 298 */         agg_rowWriter1.write(1, agg_value11);
/* 299 */       }
/* 300 */
/* 301 */       if (agg_isNull12) {
/* 302 */         agg_rowWriter1.setNullAt(2);
/* 303 */       } else {
/* 304 */         agg_rowWriter1.write(2, agg_value12);
/* 305 */       }
/* 306 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 307 */       append(agg_result1.copy());
/* 308 */
/* 309 */       if (shouldStop()) return;
/* 310 */     }
/* 311 */
/* 312 */     agg_mapIter.close();
/* 313 */     if (agg_sorter == null) {
/* 314 */       agg_hashMap.free();
/* 315 */     }
/* 316 */   }
/* 317 */ }

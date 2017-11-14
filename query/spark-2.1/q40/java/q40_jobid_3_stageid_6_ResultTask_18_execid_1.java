/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private double agg_bufValue1;
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private UnsafeRow agg_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value8;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     agg_initAgg = false;
/* 038 */
/* 039 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 040 */
/* 041 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 042 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 043 */     inputadapter_input = inputs[0];
/* 044 */     agg_result = new UnsafeRow(2);
/* 045 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 046 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 047 */
/* 048 */     agg_result1 = new UnsafeRow(4);
/* 049 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 050 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 4);
/* 051 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 052 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 057 */     agg_hashMap = agg_plan.createHashMap();
/* 058 */
/* 059 */     while (inputadapter_input.hasNext()) {
/* 060 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 061 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 062 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 063 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 064 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 065 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 066 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 067 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 068 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 069 */
/* 070 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 071 */
/* 072 */       UnsafeRow agg_fastAggBuffer = null;
/* 073 */
/* 074 */       if (agg_fastAggBuffer == null) {
/* 075 */         // generate grouping key
/* 076 */         agg_holder.reset();
/* 077 */
/* 078 */         agg_rowWriter.zeroOutNullBytes();
/* 079 */
/* 080 */         if (inputadapter_isNull) {
/* 081 */           agg_rowWriter.setNullAt(0);
/* 082 */         } else {
/* 083 */           agg_rowWriter.write(0, inputadapter_value);
/* 084 */         }
/* 085 */
/* 086 */         if (inputadapter_isNull1) {
/* 087 */           agg_rowWriter.setNullAt(1);
/* 088 */         } else {
/* 089 */           agg_rowWriter.write(1, inputadapter_value1);
/* 090 */         }
/* 091 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 092 */         agg_value8 = 42;
/* 093 */
/* 094 */         if (!inputadapter_isNull) {
/* 095 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value8);
/* 096 */         }
/* 097 */
/* 098 */         if (!inputadapter_isNull1) {
/* 099 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value8);
/* 100 */         }
/* 101 */         if (true) {
/* 102 */           // try to get the buffer from hash map
/* 103 */           agg_unsafeRowAggBuffer =
/* 104 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 105 */         }
/* 106 */         if (agg_unsafeRowAggBuffer == null) {
/* 107 */           if (agg_sorter == null) {
/* 108 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 109 */           } else {
/* 110 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 111 */           }
/* 112 */
/* 113 */           // the hash map had be spilled, it should have enough memory now,
/* 114 */           // try  to allocate buffer again.
/* 115 */           agg_unsafeRowAggBuffer =
/* 116 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 117 */           if (agg_unsafeRowAggBuffer == null) {
/* 118 */             // failed to allocate the first page
/* 119 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 120 */           }
/* 121 */         }
/* 122 */       }
/* 123 */
/* 124 */       if (agg_fastAggBuffer != null) {
/* 125 */         // update fast row
/* 126 */
/* 127 */       } else {
/* 128 */         // update unsafe row
/* 129 */
/* 130 */         // common sub-expressions
/* 131 */         boolean agg_isNull9 = false;
/* 132 */         double agg_value11 = -1.0;
/* 133 */         if (!false) {
/* 134 */           agg_value11 = (double) 0;
/* 135 */         }
/* 136 */         // evaluate aggregate function
/* 137 */         boolean agg_isNull12 = true;
/* 138 */         double agg_value14 = -1.0;
/* 139 */
/* 140 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 141 */         double agg_value16 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 142 */         boolean agg_isNull13 = agg_isNull14;
/* 143 */         double agg_value15 = agg_value16;
/* 144 */         if (agg_isNull13) {
/* 145 */           if (!agg_isNull9) {
/* 146 */             agg_isNull13 = false;
/* 147 */             agg_value15 = agg_value11;
/* 148 */           }
/* 149 */         }
/* 150 */
/* 151 */         if (!inputadapter_isNull2) {
/* 152 */           agg_isNull12 = false; // resultCode could change nullability.
/* 153 */           agg_value14 = agg_value15 + inputadapter_value2;
/* 154 */
/* 155 */         }
/* 156 */         boolean agg_isNull11 = agg_isNull12;
/* 157 */         double agg_value13 = agg_value14;
/* 158 */         if (agg_isNull11) {
/* 159 */           boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 160 */           double agg_value18 = agg_isNull16 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 161 */           if (!agg_isNull16) {
/* 162 */             agg_isNull11 = false;
/* 163 */             agg_value13 = agg_value18;
/* 164 */           }
/* 165 */         }
/* 166 */         boolean agg_isNull18 = true;
/* 167 */         double agg_value20 = -1.0;
/* 168 */
/* 169 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 170 */         double agg_value22 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 171 */         boolean agg_isNull19 = agg_isNull20;
/* 172 */         double agg_value21 = agg_value22;
/* 173 */         if (agg_isNull19) {
/* 174 */           if (!agg_isNull9) {
/* 175 */             agg_isNull19 = false;
/* 176 */             agg_value21 = agg_value11;
/* 177 */           }
/* 178 */         }
/* 179 */
/* 180 */         if (!inputadapter_isNull3) {
/* 181 */           agg_isNull18 = false; // resultCode could change nullability.
/* 182 */           agg_value20 = agg_value21 + inputadapter_value3;
/* 183 */
/* 184 */         }
/* 185 */         boolean agg_isNull17 = agg_isNull18;
/* 186 */         double agg_value19 = agg_value20;
/* 187 */         if (agg_isNull17) {
/* 188 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 189 */           double agg_value24 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 190 */           if (!agg_isNull22) {
/* 191 */             agg_isNull17 = false;
/* 192 */             agg_value19 = agg_value24;
/* 193 */           }
/* 194 */         }
/* 195 */         // update unsafe row buffer
/* 196 */         if (!agg_isNull11) {
/* 197 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value13);
/* 198 */         } else {
/* 199 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 200 */         }
/* 201 */
/* 202 */         if (!agg_isNull17) {
/* 203 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value19);
/* 204 */         } else {
/* 205 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 206 */         }
/* 207 */
/* 208 */       }
/* 209 */       if (shouldStop()) return;
/* 210 */     }
/* 211 */
/* 212 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 213 */   }
/* 214 */
/* 215 */   protected void processNext() throws java.io.IOException {
/* 216 */     if (!agg_initAgg) {
/* 217 */       agg_initAgg = true;
/* 218 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 219 */       agg_doAggregateWithKeys();
/* 220 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 221 */     }
/* 222 */
/* 223 */     // output the result
/* 224 */
/* 225 */     while (agg_mapIter.next()) {
/* 226 */       wholestagecodegen_numOutputRows.add(1);
/* 227 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 228 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 229 */
/* 230 */       boolean agg_isNull23 = agg_aggKey.isNullAt(0);
/* 231 */       UTF8String agg_value25 = agg_isNull23 ? null : (agg_aggKey.getUTF8String(0));
/* 232 */       boolean agg_isNull24 = agg_aggKey.isNullAt(1);
/* 233 */       UTF8String agg_value26 = agg_isNull24 ? null : (agg_aggKey.getUTF8String(1));
/* 234 */       boolean agg_isNull25 = agg_aggBuffer.isNullAt(0);
/* 235 */       double agg_value27 = agg_isNull25 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 236 */       boolean agg_isNull26 = agg_aggBuffer.isNullAt(1);
/* 237 */       double agg_value28 = agg_isNull26 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 238 */
/* 239 */       agg_holder1.reset();
/* 240 */
/* 241 */       agg_rowWriter1.zeroOutNullBytes();
/* 242 */
/* 243 */       if (agg_isNull23) {
/* 244 */         agg_rowWriter1.setNullAt(0);
/* 245 */       } else {
/* 246 */         agg_rowWriter1.write(0, agg_value25);
/* 247 */       }
/* 248 */
/* 249 */       if (agg_isNull24) {
/* 250 */         agg_rowWriter1.setNullAt(1);
/* 251 */       } else {
/* 252 */         agg_rowWriter1.write(1, agg_value26);
/* 253 */       }
/* 254 */
/* 255 */       if (agg_isNull25) {
/* 256 */         agg_rowWriter1.setNullAt(2);
/* 257 */       } else {
/* 258 */         agg_rowWriter1.write(2, agg_value27);
/* 259 */       }
/* 260 */
/* 261 */       if (agg_isNull26) {
/* 262 */         agg_rowWriter1.setNullAt(3);
/* 263 */       } else {
/* 264 */         agg_rowWriter1.write(3, agg_value28);
/* 265 */       }
/* 266 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 267 */       append(agg_result1);
/* 268 */
/* 269 */       if (shouldStop()) return;
/* 270 */     }
/* 271 */
/* 272 */     agg_mapIter.close();
/* 273 */     if (agg_sorter == null) {
/* 274 */       agg_hashMap.free();
/* 275 */     }
/* 276 */   }
/* 277 */ }

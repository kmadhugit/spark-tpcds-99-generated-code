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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value4;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 026 */   private UnsafeRow filter_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 029 */   private UnsafeRow project_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 034 */
/* 035 */   public GeneratedIterator(Object[] references) {
/* 036 */     this.references = references;
/* 037 */   }
/* 038 */
/* 039 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 040 */     partitionIndex = index;
/* 041 */     this.inputs = inputs;
/* 042 */     wholestagecodegen_init_0();
/* 043 */     wholestagecodegen_init_1();
/* 044 */
/* 045 */   }
/* 046 */
/* 047 */   private void wholestagecodegen_init_0() {
/* 048 */     agg_initAgg = false;
/* 049 */
/* 050 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 051 */
/* 052 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 053 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 054 */     inputadapter_input = inputs[0];
/* 055 */     agg_result = new UnsafeRow(1);
/* 056 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 057 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 058 */
/* 059 */     agg_result1 = new UnsafeRow(2);
/* 060 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 061 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 062 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 063 */     filter_result = new UnsafeRow(2);
/* 064 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 065 */
/* 066 */   }
/* 067 */
/* 068 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 069 */     agg_hashMap = agg_plan.createHashMap();
/* 070 */
/* 071 */     while (inputadapter_input.hasNext()) {
/* 072 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 073 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 074 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 075 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 076 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 077 */
/* 078 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 079 */
/* 080 */       UnsafeRow agg_fastAggBuffer = null;
/* 081 */
/* 082 */       if (agg_fastAggBuffer == null) {
/* 083 */         // generate grouping key
/* 084 */         agg_rowWriter.zeroOutNullBytes();
/* 085 */
/* 086 */         if (inputadapter_isNull) {
/* 087 */           agg_rowWriter.setNullAt(0);
/* 088 */         } else {
/* 089 */           agg_rowWriter.write(0, inputadapter_value);
/* 090 */         }
/* 091 */         agg_value4 = 42;
/* 092 */
/* 093 */         if (!inputadapter_isNull) {
/* 094 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value4);
/* 095 */         }
/* 096 */         if (true) {
/* 097 */           // try to get the buffer from hash map
/* 098 */           agg_unsafeRowAggBuffer =
/* 099 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 100 */         }
/* 101 */         if (agg_unsafeRowAggBuffer == null) {
/* 102 */           if (agg_sorter == null) {
/* 103 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 104 */           } else {
/* 105 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 106 */           }
/* 107 */
/* 108 */           // the hash map had be spilled, it should have enough memory now,
/* 109 */           // try  to allocate buffer again.
/* 110 */           agg_unsafeRowAggBuffer =
/* 111 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 112 */           if (agg_unsafeRowAggBuffer == null) {
/* 113 */             // failed to allocate the first page
/* 114 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 115 */           }
/* 116 */         }
/* 117 */       }
/* 118 */
/* 119 */       if (agg_fastAggBuffer != null) {
/* 120 */         // update fast row
/* 121 */
/* 122 */       } else {
/* 123 */         // update unsafe row
/* 124 */
/* 125 */         // common sub-expressions
/* 126 */
/* 127 */         // evaluate aggregate function
/* 128 */         boolean agg_isNull6 = true;
/* 129 */         double agg_value7 = -1.0;
/* 130 */
/* 131 */         boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 132 */         double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 133 */         boolean agg_isNull7 = agg_isNull8;
/* 134 */         double agg_value8 = agg_value9;
/* 135 */         if (agg_isNull7) {
/* 136 */           boolean agg_isNull9 = false;
/* 137 */           double agg_value10 = -1.0;
/* 138 */           if (!false) {
/* 139 */             agg_value10 = (double) 0;
/* 140 */           }
/* 141 */           if (!agg_isNull9) {
/* 142 */             agg_isNull7 = false;
/* 143 */             agg_value8 = agg_value10;
/* 144 */           }
/* 145 */         }
/* 146 */
/* 147 */         if (!inputadapter_isNull1) {
/* 148 */           agg_isNull6 = false; // resultCode could change nullability.
/* 149 */           agg_value7 = agg_value8 + inputadapter_value1;
/* 150 */
/* 151 */         }
/* 152 */         boolean agg_isNull5 = agg_isNull6;
/* 153 */         double agg_value6 = agg_value7;
/* 154 */         if (agg_isNull5) {
/* 155 */           boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 156 */           double agg_value13 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 157 */           if (!agg_isNull12) {
/* 158 */             agg_isNull5 = false;
/* 159 */             agg_value6 = agg_value13;
/* 160 */           }
/* 161 */         }
/* 162 */         // update unsafe row buffer
/* 163 */         if (!agg_isNull5) {
/* 164 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 165 */         } else {
/* 166 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 167 */         }
/* 168 */
/* 169 */       }
/* 170 */       if (shouldStop()) return;
/* 171 */     }
/* 172 */
/* 173 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 174 */   }
/* 175 */
/* 176 */   private void wholestagecodegen_init_1() {
/* 177 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 178 */     project_result = new UnsafeRow(1);
/* 179 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 180 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 181 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 182 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 183 */
/* 184 */   }
/* 185 */
/* 186 */   protected void processNext() throws java.io.IOException {
/* 187 */     if (!agg_initAgg) {
/* 188 */       agg_initAgg = true;
/* 189 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 190 */       agg_doAggregateWithKeys();
/* 191 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 192 */     }
/* 193 */
/* 194 */     // output the result
/* 195 */
/* 196 */     while (agg_mapIter.next()) {
/* 197 */       wholestagecodegen_numOutputRows.add(1);
/* 198 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 199 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 200 */
/* 201 */       boolean agg_isNull13 = agg_aggKey.isNullAt(0);
/* 202 */       int agg_value14 = agg_isNull13 ? -1 : (agg_aggKey.getInt(0));
/* 203 */       boolean agg_isNull14 = agg_aggBuffer.isNullAt(0);
/* 204 */       double agg_value15 = agg_isNull14 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 205 */
/* 206 */       if (!(!(agg_isNull14))) continue;
/* 207 */
/* 208 */       boolean filter_isNull2 = true;
/* 209 */       boolean filter_value2 = false;
/* 210 */
/* 211 */       boolean filter_isNull4 = true;
/* 212 */       double filter_value4 = -1.0;
/* 213 */
/* 214 */       final double filter_value6 = -1.0;
/* 215 */       if (!true) {
/* 216 */         filter_isNull4 = false; // resultCode could change nullability.
/* 217 */         filter_value4 = 0.5D * filter_value6;
/* 218 */
/* 219 */       }
/* 220 */       if (!filter_isNull4) {
/* 221 */         filter_isNull2 = false; // resultCode could change nullability.
/* 222 */         filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value15, filter_value4) > 0;
/* 223 */
/* 224 */       }
/* 225 */       if (filter_isNull2 || !filter_value2) continue;
/* 226 */
/* 227 */       filter_numOutputRows.add(1);
/* 228 */
/* 229 */       project_rowWriter.zeroOutNullBytes();
/* 230 */
/* 231 */       if (agg_isNull13) {
/* 232 */         project_rowWriter.setNullAt(0);
/* 233 */       } else {
/* 234 */         project_rowWriter.write(0, agg_value14);
/* 235 */       }
/* 236 */       append(project_result);
/* 237 */
/* 238 */       if (shouldStop()) return;
/* 239 */     }
/* 240 */
/* 241 */     agg_mapIter.close();
/* 242 */     if (agg_sorter == null) {
/* 243 */       agg_hashMap.free();
/* 244 */     }
/* 245 */   }
/* 246 */ }

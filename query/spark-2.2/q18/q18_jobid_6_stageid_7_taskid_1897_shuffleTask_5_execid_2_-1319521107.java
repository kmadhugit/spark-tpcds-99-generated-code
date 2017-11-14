/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 023 */   private UnsafeRow scan_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 027 */   private UnsafeRow filter_result;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 030 */   private UnsafeRow project_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 033 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 034 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 036 */   private UnsafeRow bhj_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 039 */   private UnsafeRow project_result1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 042 */
/* 043 */   public GeneratedIterator(Object[] references) {
/* 044 */     this.references = references;
/* 045 */   }
/* 046 */
/* 047 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 048 */     partitionIndex = index;
/* 049 */     this.inputs = inputs;
/* 050 */     wholestagecodegen_init_0();
/* 051 */     wholestagecodegen_init_1();
/* 052 */
/* 053 */   }
/* 054 */
/* 055 */   private void wholestagecodegen_init_0() {
/* 056 */     scan_input = inputs[0];
/* 057 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 058 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 059 */     scan_scanTime1 = 0;
/* 060 */     scan_batch = null;
/* 061 */     scan_batchIdx = 0;
/* 062 */     scan_colInstance0 = null;
/* 063 */     scan_colInstance1 = null;
/* 064 */     scan_colInstance2 = null;
/* 065 */     scan_colInstance3 = null;
/* 066 */     scan_colInstance4 = null;
/* 067 */     scan_colInstance5 = null;
/* 068 */     scan_colInstance6 = null;
/* 069 */     scan_colInstance7 = null;
/* 070 */     scan_colInstance8 = null;
/* 071 */     scan_result = new UnsafeRow(9);
/* 072 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 073 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 9);
/* 074 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 075 */     filter_result = new UnsafeRow(9);
/* 076 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 077 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 9);
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   private void scan_nextBatch() throws java.io.IOException {
/* 082 */     long getBatchStart = System.nanoTime();
/* 083 */     if (scan_input.hasNext()) {
/* 084 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 085 */       scan_numOutputRows.add(scan_batch.numRows());
/* 086 */       scan_batchIdx = 0;
/* 087 */       scan_colInstance0 = scan_batch.column(0);
/* 088 */       scan_colInstance1 = scan_batch.column(1);
/* 089 */       scan_colInstance2 = scan_batch.column(2);
/* 090 */       scan_colInstance3 = scan_batch.column(3);
/* 091 */       scan_colInstance4 = scan_batch.column(4);
/* 092 */       scan_colInstance5 = scan_batch.column(5);
/* 093 */       scan_colInstance6 = scan_batch.column(6);
/* 094 */       scan_colInstance7 = scan_batch.column(7);
/* 095 */       scan_colInstance8 = scan_batch.column(8);
/* 096 */
/* 097 */     }
/* 098 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 099 */   }
/* 100 */
/* 101 */   private void wholestagecodegen_init_1() {
/* 102 */     project_result = new UnsafeRow(9);
/* 103 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 104 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 9);
/* 105 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 106 */
/* 107 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 108 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 109 */
/* 110 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 111 */     bhj_result = new UnsafeRow(11);
/* 112 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 113 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 11);
/* 114 */     project_result1 = new UnsafeRow(9);
/* 115 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 116 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 9);
/* 117 */
/* 118 */   }
/* 119 */
/* 120 */   protected void processNext() throws java.io.IOException {
/* 121 */     if (scan_batch == null) {
/* 122 */       scan_nextBatch();
/* 123 */     }
/* 124 */     while (scan_batch != null) {
/* 125 */       int scan_numRows = scan_batch.numRows();
/* 126 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 127 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 128 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 129 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 130 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 131 */
/* 132 */         if (!(!(scan_isNull1))) continue;
/* 133 */
/* 134 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 135 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 136 */
/* 137 */         if (!(!(scan_isNull))) continue;
/* 138 */
/* 139 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 140 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 141 */
/* 142 */         if (!(!(scan_isNull2))) continue;
/* 143 */
/* 144 */         filter_numOutputRows.add(1);
/* 145 */
/* 146 */         // generate join key for stream side
/* 147 */
/* 148 */         boolean bhj_isNull = false;
/* 149 */         long bhj_value = -1L;
/* 150 */         if (!false) {
/* 151 */           bhj_value = (long) scan_value1;
/* 152 */         }
/* 153 */         // find matches from HashedRelation
/* 154 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 155 */         if (bhj_matched == null) continue;
/* 156 */
/* 157 */         bhj_numOutputRows.add(1);
/* 158 */
/* 159 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 160 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 161 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 162 */         double scan_value4 = scan_isNull4 ? -1.0 : (scan_colInstance4.getDouble(scan_rowIdx));
/* 163 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 164 */         double scan_value5 = scan_isNull5 ? -1.0 : (scan_colInstance5.getDouble(scan_rowIdx));
/* 165 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 166 */         double scan_value6 = scan_isNull6 ? -1.0 : (scan_colInstance6.getDouble(scan_rowIdx));
/* 167 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 168 */         double scan_value7 = scan_isNull7 ? -1.0 : (scan_colInstance7.getDouble(scan_rowIdx));
/* 169 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 170 */         int scan_value8 = scan_isNull8 ? -1 : (scan_colInstance8.getInt(scan_rowIdx));
/* 171 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 172 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 173 */         project_rowWriter1.zeroOutNullBytes();
/* 174 */
/* 175 */         project_rowWriter1.write(0, scan_value);
/* 176 */
/* 177 */         project_rowWriter1.write(1, scan_value2);
/* 178 */
/* 179 */         if (scan_isNull3) {
/* 180 */           project_rowWriter1.setNullAt(2);
/* 181 */         } else {
/* 182 */           project_rowWriter1.write(2, scan_value3);
/* 183 */         }
/* 184 */
/* 185 */         if (scan_isNull4) {
/* 186 */           project_rowWriter1.setNullAt(3);
/* 187 */         } else {
/* 188 */           project_rowWriter1.write(3, scan_value4);
/* 189 */         }
/* 190 */
/* 191 */         if (scan_isNull5) {
/* 192 */           project_rowWriter1.setNullAt(4);
/* 193 */         } else {
/* 194 */           project_rowWriter1.write(4, scan_value5);
/* 195 */         }
/* 196 */
/* 197 */         if (scan_isNull6) {
/* 198 */           project_rowWriter1.setNullAt(5);
/* 199 */         } else {
/* 200 */           project_rowWriter1.write(5, scan_value6);
/* 201 */         }
/* 202 */
/* 203 */         if (scan_isNull7) {
/* 204 */           project_rowWriter1.setNullAt(6);
/* 205 */         } else {
/* 206 */           project_rowWriter1.write(6, scan_value7);
/* 207 */         }
/* 208 */
/* 209 */         if (scan_isNull8) {
/* 210 */           project_rowWriter1.setNullAt(7);
/* 211 */         } else {
/* 212 */           project_rowWriter1.write(7, scan_value8);
/* 213 */         }
/* 214 */
/* 215 */         if (bhj_isNull3) {
/* 216 */           project_rowWriter1.setNullAt(8);
/* 217 */         } else {
/* 218 */           project_rowWriter1.write(8, bhj_value3);
/* 219 */         }
/* 220 */         append(project_result1);
/* 221 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 222 */       }
/* 223 */       scan_batchIdx = scan_numRows;
/* 224 */       scan_batch = null;
/* 225 */       scan_nextBatch();
/* 226 */     }
/* 227 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 228 */     scan_scanTime1 = 0;
/* 229 */   }
/* 230 */ }

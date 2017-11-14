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
/* 016 */   private int compare_1(InternalRow a, InternalRow b) {
/* 017 */
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA2;
/* 022 */     UTF8String primitiveA2;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull2 = i.isNullAt(1);
/* 026 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(1));
/* 027 */       isNullA2 = isNull2;
/* 028 */       primitiveA2 = value2;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB2;
/* 032 */     UTF8String primitiveB2;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull2 = i.isNullAt(1);
/* 036 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(1));
/* 037 */       isNullB2 = isNull2;
/* 038 */       primitiveB2 = value2;
/* 039 */     }
/* 040 */     if (isNullA2 && isNullB2) {
/* 041 */       // Nothing
/* 042 */     } else if (isNullA2) {
/* 043 */       return -1;
/* 044 */     } else if (isNullB2) {
/* 045 */       return 1;
/* 046 */     } else {
/* 047 */       int comp = primitiveA2.compare(primitiveB2);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */     i = a;
/* 054 */     boolean isNullA3;
/* 055 */     int primitiveA3;
/* 056 */     {
/* 057 */
/* 058 */       boolean isNull3 = i.isNullAt(2);
/* 059 */       int value3 = isNull3 ? -1 : (i.getInt(2));
/* 060 */       isNullA3 = isNull3;
/* 061 */       primitiveA3 = value3;
/* 062 */     }
/* 063 */     i = b;
/* 064 */     boolean isNullB3;
/* 065 */     int primitiveB3;
/* 066 */     {
/* 067 */
/* 068 */       boolean isNull3 = i.isNullAt(2);
/* 069 */       int value3 = isNull3 ? -1 : (i.getInt(2));
/* 070 */       isNullB3 = isNull3;
/* 071 */       primitiveB3 = value3;
/* 072 */     }
/* 073 */     if (isNullA3 && isNullB3) {
/* 074 */       // Nothing
/* 075 */     } else if (isNullA3) {
/* 076 */       return -1;
/* 077 */     } else if (isNullB3) {
/* 078 */       return 1;
/* 079 */     } else {
/* 080 */       int comp = (primitiveA3 > primitiveB3 ? 1 : primitiveA3 < primitiveB3 ? -1 : 0);
/* 081 */       if (comp != 0) {
/* 082 */         return comp;
/* 083 */       }
/* 084 */     }
/* 085 */
/* 086 */     return 0;
/* 087 */
/* 088 */   }
/* 089 */
/* 090 */
/* 091 */   private int compare_0(InternalRow a, InternalRow b) {
/* 092 */
/* 093 */     InternalRow i = null;  // Holds current row being evaluated.
/* 094 */
/* 095 */     i = a;
/* 096 */     boolean isNullA;
/* 097 */     long primitiveA;
/* 098 */     {
/* 099 */
/* 100 */       long value = i.getLong(5);
/* 101 */       isNullA = false;
/* 102 */       primitiveA = value;
/* 103 */     }
/* 104 */     i = b;
/* 105 */     boolean isNullB;
/* 106 */     long primitiveB;
/* 107 */     {
/* 108 */
/* 109 */       long value = i.getLong(5);
/* 110 */       isNullB = false;
/* 111 */       primitiveB = value;
/* 112 */     }
/* 113 */     if (isNullA && isNullB) {
/* 114 */       // Nothing
/* 115 */     } else if (isNullA) {
/* 116 */       return 1;
/* 117 */     } else if (isNullB) {
/* 118 */       return -1;
/* 119 */     } else {
/* 120 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 121 */       if (comp != 0) {
/* 122 */         return -comp;
/* 123 */       }
/* 124 */     }
/* 125 */
/* 126 */     i = a;
/* 127 */     boolean isNullA1;
/* 128 */     UTF8String primitiveA1;
/* 129 */     {
/* 130 */
/* 131 */       boolean isNull1 = i.isNullAt(0);
/* 132 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 133 */       isNullA1 = isNull1;
/* 134 */       primitiveA1 = value1;
/* 135 */     }
/* 136 */     i = b;
/* 137 */     boolean isNullB1;
/* 138 */     UTF8String primitiveB1;
/* 139 */     {
/* 140 */
/* 141 */       boolean isNull1 = i.isNullAt(0);
/* 142 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 143 */       isNullB1 = isNull1;
/* 144 */       primitiveB1 = value1;
/* 145 */     }
/* 146 */     if (isNullA1 && isNullB1) {
/* 147 */       // Nothing
/* 148 */     } else if (isNullA1) {
/* 149 */       return -1;
/* 150 */     } else if (isNullB1) {
/* 151 */       return 1;
/* 152 */     } else {
/* 153 */       int comp = primitiveA1.compare(primitiveB1);
/* 154 */       if (comp != 0) {
/* 155 */         return comp;
/* 156 */       }
/* 157 */     }
/* 158 */
/* 159 */     return 0;
/* 160 */
/* 161 */   }
/* 162 */
/* 163 */
/* 164 */   public int compare(InternalRow a, InternalRow b) {
/* 165 */
/* 166 */     InternalRow i = null;
/* 167 */
/* 168 */     int comp = compare_0(a, b);
/* 169 */     if (comp != 0) {
/* 170 */       return comp;
/* 171 */     }
/* 172 */
/* 173 */     int comp1 = compare_1(a, b);
/* 174 */     if (comp1 != 0) {
/* 175 */       return comp1;
/* 176 */     }
/* 177 */
/* 178 */
/* 179 */     return 0;
/* 180 */   }
/* 181 */ }
